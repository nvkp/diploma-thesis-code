# Values’ Characteristics By Sex Dimension Value

```
PREFIX qb: <http://purl.org/linked-data/cube#>
PREFIX czso: <http://data.czso.cz/ontology/>

SELECT ?sex
(avg(?averageSalary) as ?avgAverageSalary)
(avg(?medianSalary) as ?avgMedianSalary)
(min(?averageSalary) as ?minAverageSalary)
(min(?medianSalary) as ?minMedianSalary)
(max(?averageSalary) as ?maxAverageSalary)
(max(?medianSalary) as ?maxMedianSalary)

WHERE {
  GRAPH <http://data.czso.cz/resource/dataset/average-salaries> {
       ?observation qb:dataSet <http://data.czso.cz/resource/dataset/average-salaries> ; 
                    czso:sex ?sex ;
                    czso:prumernaMzda ?averageSalary ;
                    czso:medianMzdy ?medianSalary .
    				
  }
}
GROUP BY ?sex
```

# Result

```
 "sex" , "avgAverageSalary" , "avgMedianSalary" , "minAverageSalary" , "minMedianSalary" , "maxAverageSalary" , "maxMedianSalary" ,
 "http://purl.org/linked-data/sdmx/2009/code#sex-M" , "27408.023809523809523809523809" , "23576.571428571428571428571428" , "23799.0" , "21182.0" , "41209.0" , "31063.0" ,
 "http://purl.org/linked-data/sdmx/2009/code#sex-F" , "21251.309523809523809523809523" , "19303.357142857142857142857142" , "19274.0" , "17362.0" , "30022.0" , "25728.0" ,
 "http://purl.org/linked-data/sdmx/2009/code#sex-T" , "24677.5" , "21682.071428571428571428571428" , "21723.0" , "19229.0" , "36124.0" , "28392.0" ,
```
