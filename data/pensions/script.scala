import scala.io.Source
import java.io.PrintWriter
import scala.sys.process._

val byRegion = """
?observation cssz-dimension:refArea ?refAreaCSSA .
GRAPH <https://data.cssz.cz/resource/dataset/pomocne-ciselniky> {
        ?refAreaCSSA a <https://data.cssz.cz/ontology/ruian/Vusc> .
}
"""

val byDistrict = """
?observation cssz-dimension:refArea ?refAreaCSSA .
GRAPH <https://data.cssz.cz/resource/dataset/pomocne-ciselniky> {
        ?refAreaCSSA a ?class .
        FILTER (?class IN (
            <https://data.cssz.cz/ontology/ruian/Okres>,
            <https://data.cssz.cz/ontology/ruian/SpravniObvod>
            )
        )
}
"""

val stateTotal = """
?observation cssz-dimension:refArea <https://data.cssz.cz/resource/ruian/staty/1> .
"""

/*val bySex = """
NOT EXISTS {
        ?observation cssz-dimension:pohlavi <https://data.cssz.cz/ontology/sdmx/code/sex-T>
}
"""*/

val bothSexes = """
?observation cssz-dimension:pohlavi <https://data.cssz.cz/ontology/sdmx/code/sex-T> .
"""

val female = """
?observation cssz-dimension:pohlavi <https://data.cssz.cz/ontology/sdmx/code/sex-F> .
"""

val male = """
?observation cssz-dimension:pohlavi <https://data.cssz.cz/ontology/sdmx/code/sex-M> .
"""

val template = """
PREFIX qb: <http://purl.org/linked-data/cube#>
PREFIX cssz-dimension: <https://data.cssz.cz/ontology/dimension/>

CONSTRUCT {
    ?observation ?p ?o
}
WHERE {

    ?observation qb:dataSet <https://data.cssz.cz/resource/dataset/duchodci-v-cr-krajich-okresech> .
    ?observation ?p ?o .
    %s
    ?observation cssz-dimension:druh-duchodu <%s> .
    %s
}
"""

val commandTemplate = "../../jena/bin/arq --data \"../../data/pensions-filtered.ttl\" --data \"../../data/pomocne-ciselniky.trig\" --query \"queries/%s.rq\" > \"results/male-female/%s.ttl\""
val source = Source.fromFile("pensionkinds.txt")
val lines = source.getLines().toArray
val pw = new PrintWriter(s"script.sh")
lines.foreach(line => {
    
    val kindName = line.replaceAll("https://data.cssz.cz/resource/pension-kind/","").replaceAll("_2010","")
    
    /*val districtTotalQuery = template.format(bothSexes,line,byDistrict)
    val districtTotalFileName = s"pensions-by-district-total-$kindName"
    val districtTotalPw = new PrintWriter(s"queries/$districtTotalFileName.rq")
    districtTotalPw.print(districtTotalQuery)
    districtTotalPw.close()
    pw.println(commandTemplate.format(districtTotalFileName,districtTotalFileName))

    val districtMaleQuery = template.format(male,line,byDistrict)
    val districtMaleFileName = s"pensions-by-district-male-$kindName"
    val districtMalePw = new PrintWriter(s"queries/$districtMaleFileName.rq")
    districtMalePw.print(districtMaleQuery)
    districtMalePw.close()
    pw.println(commandTemplate.format(districtMaleFileName,districtMaleFileName))

    val districtFemaleQuery = template.format(female,line,byDistrict)
    val districtFemaleFileName = s"pensions-by-district-female-$kindName"
    val districtFemalePw = new PrintWriter(s"queries/$districtFemaleFileName.rq")
    districtFemalePw.print(districtFemaleQuery)
    districtFemalePw.close()
    pw.println(commandTemplate.format(districtFemaleFileName,districtFemaleFileName))*/


    val regionTotalQuery = template.format(bothSexes,line,byRegion)
    val regionTotalFileName = s"pensions-by-region-total-$kindName"
    val regionTotalPw = new PrintWriter(s"queries/$regionTotalFileName.rq")
    regionTotalPw.print(regionTotalQuery)
    regionTotalPw.close()
    pw.println(commandTemplate.format(regionTotalFileName,regionTotalFileName))

    val regionMaleQuery = template.format(male,line,byRegion)
    val regionMaleFileName = s"pensions-by-region-male-$kindName"
    val regionMalePw = new PrintWriter(s"queries/$regionMaleFileName.rq")
    regionMalePw.print(regionMaleQuery)
    regionMalePw.close()
    pw.println(commandTemplate.format(regionMaleFileName,regionMaleFileName))

    val regionFemaleQuery = template.format(female,line,byRegion)
    val regionFemaleFileName = s"pensions-by-region-female-$kindName"
    val regionFemalePw = new PrintWriter(s"queries/$regionFemaleFileName.rq")
    regionFemalePw.print(regionFemaleQuery)
    regionFemalePw.close()
    pw.println(commandTemplate.format(regionFemaleFileName,regionFemaleFileName))




    /*val totalTotalQuery = template.format(bothSexes,line,stateTotal)
    val totalTotalFileName = s"pensions-total-total-$kindName"
    val totalTotalPw = new PrintWriter(s"queries/$totalTotalFileName.rq")
    totalTotalPw.print(totalTotalQuery)
    totalTotalPw.close()
    pw.println(commandTemplate.format(totalTotalFileName,totalTotalFileName))

    val totalFemaleQuery = template.format(female,line,stateTotal)
    val totalFemaleFileName = s"pensions-total-female-$kindName"
    val totalFemalePw = new PrintWriter(s"queries/$totalFemaleFileName.rq")
    totalFemalePw.print(totalFemaleQuery)
    totalFemalePw.close()
    pw.println(commandTemplate.format(totalFemaleFileName,totalFemaleFileName))

    val totalMaleQuery = template.format(male,line,stateTotal)
    val totalMaleFileName = s"pensions-total-male-$kindName"
    val totalMalePw = new PrintWriter(s"queries/$totalMaleFileName.rq")
    totalMalePw.print(totalMaleQuery)
    totalMalePw.close()
    pw.println(commandTemplate.format(totalMaleFileName,totalMaleFileName))*/



})

pw.close()
