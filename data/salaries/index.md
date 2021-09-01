# Salaries Subcubes

```
../../jena/bin/arq --data czso-average-salaries.trig --query slice-queries/salaries-female.rq > salaries-female.ttl
../../jena/bin/arq --data czso-average-salaries.trig --query slice-queries/salaries-male.rq > salaries-male.ttl
../../jena/bin/arq --data czso-average-salaries.trig --query slice-queries/salaries-total.rq > salaries-total.ttl
```