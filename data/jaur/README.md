```
	<http://data.czso.cz/resource/observation/job-applicants-and-unemployment-rate/CZ020/2007-12-31/M> a qb:Observation ;
		czso:refArea <http://ruian.linked.opendata.cz/resource/vusc/27> ;
		czso:refPeriod <http://reference.data.gov.uk/id/gregorian-day/2007-12-31> ;
		czso:sex sdmx-code:sex-M ;
		czso:dosazitelniNeumisteniUchazeciOZamestnani 14172.0 ;
		czso:podilNezamestnanych 2.85 ;
		qb:dataSet <http://data.czso.cz/resource/dataset/job-applicants-and-unemployment-rate> .
	
	<http://data.czso.cz/resource/observation/job-applicants-and-unemployment-rate/CZ020/2007-12-31/F> a qb:Observation ;
		czso:refArea <http://ruian.linked.opendata.cz/resource/vusc/27> ;
		czso:refPeriod <http://reference.data.gov.uk/id/gregorian-day/2007-12-31> ;
		czso:sex sdmx-code:sex-F ;
		czso:dosazitelniNeumisteniUchazeciOZamestnani 15758.0 ;
		czso:podilNezamestnanych 3.6 ;
		qb:dataSet <http://data.czso.cz/resource/dataset/job-applicants-and-unemployment-rate> .
	
	<http://data.czso.cz/resource/observation/job-applicants-and-unemployment-rate/CZ020/2013-12-31/T> a qb:Observation ;
		czso:refArea <http://ruian.linked.opendata.cz/resource/vusc/27> ;
		czso:refPeriod <http://reference.data.gov.uk/id/gregorian-day/2013-12-31> ;
		czso:sex sdmx-code:sex-T ;
		czso:neumisteniUchazeciOZamestnani 61681.0 ;
		czso:dosazitelniNeumisteniUchazeciOZamestnani 60772.0 ;
		czso:podilNezamestnanych 6.9 ;
		czso:pocetVolnychMist 4040.0 ;
		qb:dataSet <http://data.czso.cz/resource/dataset/job-applicants-and-unemployment-rate> .
```

# Schéma

## Dimenze

### http://data.czso.cz/ontology/refArea

89 hodnot -> divné
* 13 krajů
* 76 okresů -> to vychází na bez Prahy

Takže v této kostce chybí Praha?

### http://data.czso.cz/ontology/refPeriod

2005 - 2013

<http://reference.data.gov.uk/id/gregorian-day/2005-12-31>
<http://reference.data.gov.uk/id/gregorian-day/2006-12-31>
<http://reference.data.gov.uk/id/gregorian-day/2007-12-31>
<http://reference.data.gov.uk/id/gregorian-day/2008-12-31>
<http://reference.data.gov.uk/id/gregorian-day/2009-12-31>
<http://reference.data.gov.uk/id/gregorian-day/2010-12-31>
<http://reference.data.gov.uk/id/gregorian-day/2011-12-31>
<http://reference.data.gov.uk/id/gregorian-day/2012-12-31>
<http://reference.data.gov.uk/id/gregorian-day/2013-12-31>

### http://data.czso.cz/ontology/sex

<http://purl.org/linked-data/sdmx/2009/code#sex-F>
<http://purl.org/linked-data/sdmx/2009/code#sex-M>
<http://purl.org/linked-data/sdmx/2009/code#sex-T>

## Measures

### http://data.czso.cz/ontology/neumisteniUchazeciOZamestnani

MIN: 1025.0
MAX: 96528.0
AVG: 10384.691635455680399500624219

### http://data.czso.cz/ontology/dosazitelniNeumisteniUchazeciOZamestnani

MIN: 468.0
MAX: 91177.0
AVG: 6667.14856429463171036204744

### http://data.czso.cz/ontology/podilNezamestnanych

MIN: 1.13
MAX: 16.49
AVG: 6.780466084061589679567207

### http://data.czso.cz/ontology/pocetVolnychMist

MIN: 37.0
MAX: 19691.0
AVG: 1062.074906367041198501872659
