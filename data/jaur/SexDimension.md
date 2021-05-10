# Values' Characteristics By Sex Dimension Value

```sparql
PREFIX owl: <http://www.w3.org/2002/07/owl#>
PREFIX qb: <http://purl.org/linked-data/cube#>
PREFIX cssz-dimension: <https://data.cssz.cz/ontology/dimension/>
PREFIX cssz-measure:  <https://data.cssz.cz/ontology/measure/>
PREFIX czso: <http://data.czso.cz/ontology/>
PREFIX sdmx-code: <http://purl.org/linked-data/sdmx/2009/code#>

select 
?sex 
(avg(?podilNezamestnanych) as ?avgpodilNezamestnanych) 
(avg(?dosazitelniNeumisteniUchazeciOZamestnani) as ?avgdosazitelniNeumisteniUchazeciOZamestnani)
(min(?podilNezamestnanych) as ?minpodilNezamestnanych) 
(min(?dosazitelniNeumisteniUchazeciOZamestnani) as ?mindosazitelniNeumisteniUchazeciOZamestnani)
(max(?podilNezamestnanych) as ?maxpodilNezamestnanych) 
(max(?dosazitelniNeumisteniUchazeciOZamestnani) as ?maxdosazitelniNeumisteniUchazeciOZamestnani)

where {
  GRAPH <http://data.czso.cz/resource/dataset/job-applicants-and-unemployment-rate> {
       ?observation qb:dataSet <http://data.czso.cz/resource/dataset/job-applicants-and-unemployment-rate> ; 
                    czso:sex ?sex ;
                    czso:refArea ?czsoRefArea ;
                    czso:podilNezamestnanych ?podilNezamestnanych ;
                    czso:dosazitelniNeumisteniUchazeciOZamestnani ?dosazitelniNeumisteniUchazeciOZamestnani .
  }
  
   ?cssaRefArea owl:sameAs  ?czsoRefArea
  
  GRAPH <https://data.cssz.cz/resource/dataset/pomocne-ciselniky> {
  	?cssaRefArea a <https://data.cssz.cz/ontology/ruian/Okres>
  }
} 
GROUP BY ?sex
```

## Result

```csv
 "sex" , "avgpodilNezamestnanych" , "avgdosazitelniNeumisteniUchazeciOZamestnani" , "minpodilNezamestnanych" , "mindosazitelniNeumisteniUchazeciOZamestnani" , "maxpodilNezamestnanych" , "maxdosazitelniNeumisteniUchazeciOZamestnani" ,
 "http://purl.org/linked-data/sdmx/2009/code#sex-M" , "6.707163742690058479532163" , "2950.609649122807017543859649" , "1.13" , "468.0" , "15.92" , "13697.0" ,
 "http://purl.org/linked-data/sdmx/2009/code#sex-F" , "6.848581871345029239766081" , "2907.269005847953216374269005" , "1.26" , "554.0" , "16.49" , "13227.0" ,
 "http://purl.org/linked-data/sdmx/2009/code#sex-T" , "6.776593567251461988304093" , "5853.494152046783625730994152" , "1.2" , "901.0" , "16.2" , "25767.0" ,
```
