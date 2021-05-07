# Nalezení relevantních dat v YAGO

Takto vypadá IRI Jihomoravského kraje v YAGO: <http://yago-knowledge.org/resource/South_Moravian_Region>.

[http://vos.openlinksw.com/owiki/wiki/VOS/VOSSparqlProtocol](http://vos.openlinksw.com/owiki/wiki/VOS/VOSSparqlProtocol)

```bash
curl -X POST -d @query.rq -H Content-Type: application/x-www-form-urlencoded 'https://yago-knowledge.org/sparql/query' > result.xml
```

## Nalezení všech krajů ČR:

```sparql
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX yago: <http://yago-knowledge.org/resource/>

select distinct ?region where {
?region a yago:Regions_of_the_Czech_Republic
}
```

```bash
curl -X POST -d @queries/regions.rq -H 'Content-Type: application/x-www-form-urlencoded' 'https://yago-knowledge.org/sparql/query' > results/regions.xml
```

## Takto se dostanu k okresům

```sparql
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX yago: <http://yago-knowledge.org/resource/>
PREFIX schema: <http://schema.org/>

select distinct ?district where {
?region a yago:Regions_of_the_Czech_Republic; schema:containsPlace ?district.
?district a yago:Districts_of_the_Czech_Republic .
}
```

```bash
curl -X POST -d @queries/districts.rq -H 'Content-Type: application/x-www-form-urlencoded' 'https://yago-knowledge.org/sparql/query' > results/districts.xml
```

## Describe Regions

```sparql
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX yago: <http://yago-knowledge.org/resource/>

describe ?region where {
?region a yago:Regions_of_the_Czech_Republic
}
```

```bash
curl -X POST -d @queries/describe-regions.rq -H 'Content-Type: application/x-www-form-urlencoded' -H 'Accept: text/turtle' 'https://yago-knowledge.org/sparql/query' > results/describe-regions.ttl
```

## Describe Districts

```sparql
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX yago: <http://yago-knowledge.org/resource/>
PREFIX schema: <http://schema.org/>

describe ?district where {
?region a yago:Regions_of_the_Czech_Republic; schema:containsPlace ?district.
?district a yago:Districts_of_the_Czech_Republic .
}
```

```bash
curl -X POST -d @queries/describe-districts.rq -H 'Content-Type: application/x-www-form-urlencoded' -H 'Accept: text/turtle' 'https://yago-knowledge.org/sparql/query' > results/describe-districts.ttl
```

## Describe Regions HOP 1

```sparql
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX yago: <http://yago-knowledge.org/resource/>

describe ?hop1 where {
?region a yago:Regions_of_the_Czech_Republic .
?hop1 ?p ?region .
}
```

```bash
curl -X POST -d @queries/describe-regions-hop1.rq -H 'Content-Type: application/x-www-form-urlencoded' -H 'Accept: text/turtle' 'https://yago-knowledge.org/sparql/query' > results/describe-regions-hop1.ttl
```

## Describe Districts HOP 1

```sparql
PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
PREFIX yago: <http://yago-knowledge.org/resource/>
PREFIX schema: <http://schema.org/>

describe ?hop1 where {
?region a yago:Regions_of_the_Czech_Republic; schema:containsPlace ?district .
?district a yago:Districts_of_the_Czech_Republic .
?hop1 ?p ?district .
}
```

```bash
curl -X POST -d @queries/describe-districts-hop1.rq -H 'Content-Type: application/x-www-form-urlencoded' -H 'Accept: text/turtle' 'https://yago-knowledge.org/sparql/query' > results/describe-districts-hop1.ttl
```

## Describe Regions HOP 2

```sparql
PREFIX yago: <http://yago-knowledge.org/resource/>

describe ?hop2 where {
?region a yago:Regions_of_the_Czech_Republic .
?hop1 ?p1 ?region .
?hop2 ?p2 ?hop1 .
}
```

```bash
curl -X POST -d @queries/describe-regions-hop2.rq -H 'Content-Type: application/x-www-form-urlencoded' -H 'Accept: text/turtle' 'https://yago-knowledge.org/sparql/query' > results/describe-regions-hop2.ttl
```

## Describe Districts HOP 2

```sparql
PREFIX yago: <http://yago-knowledge.org/resource/>
PREFIX schema: <http://schema.org/>

describe ?hop2 where {
?region a yago:Regions_of_the_Czech_Republic; schema:containsPlace ?district .
?district a yago:Districts_of_the_Czech_Republic .
?hop1 ?p1 ?district .
?hop2 ?p2 ?hop1 .
}
```

```bash
curl -X POST -d @queries/describe-districts-hop2.rq -H 'Content-Type: application/x-www-form-urlencoded' -H 'Accept: text/turtle' 'https://yago-knowledge.org/sparql/query' > results/describe-districts-hop2.ttl
```
