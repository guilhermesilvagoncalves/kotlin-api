# kotlin-api-example

##Purpouse
This repository intends to be a code example of a rest API, using Kotlin + Spring framework.
It simulates a CRUD repository os fairs and its attributes.

##Requirements
To run this API, the host needs to have:
* Apache Maven 3.8.1 or higher
* JDK version: 17.0.3
* Kotlin version 1.5.21
* An instance of postgres, preferably on localhost

##Setup
###Database instance
To run this app, first, you need to have an instance of Postgres Database running somewhere. This instance will be used by application to persist data and works as a CRUD repository.
To indicate where is your instance, change [application.properties](src/main/resources/application.properties) file with data about this instance of database.
* Preferably create a specific database, to isolate changes from another ones

###Database mass of data
For these tests, on [databaseFiles](src/main/resources/databaseFiles) exists a csv file, with a mass of registers, to populate database before tests.
To create database DDL, run application. It will create this configuration automatically:
`./mvnw spring-boot:run`

After configure database, to import the data:
* Open Postges using command line (requires access to its hosts, in case its not running locally)
`psql postgres`
* Set your terminal to manage the database you created. In that case, we used fairDb name:
`\c fairDb`
* Copy file  [DEINFO_AB_FEIRASLIVRES_2014.csv](src/main/resources/databaseFiles/DEINFO_AB_FEIRASLIVRES_2014.csv) to this specific host
* Run command to copy the data from csv to the database, substituting the path for your application: 
`COPY fair (LONG,LAT,SETCENS,AREAP,CODDIST,DISTRITO,CODSUBPREF,SUBPREFE,REGIAO5,REGIAO8,NOME_FEIRA,REGISTRO,LOGRADOURO,NUMERO,BAIRRO,REFERENCIA) FROM '{insert-path-to-file}/DEINFO_AB_FEIRASLIVRES_2014.csv' WITH (FORMAT csv);` 
After these steps, is expected that your database is filled with a bunch of fair registers
`select * from fair f`

##More info


###How to run application

`./mvnw clean install`

`./mvnw spring-boot:run`


###How to run tests

`./mvnw test`


###Endpoints

###Create new fair

**URL:** POST /

**Status response:** 201 CREATED

Body request example:
```
{
    "longitude": -46548146,
    "lagitude": -23568390,
    "setcens": 355030885000019,
    "areap": 3550308005040,
    "coddist": 87,
    "distrito": "VILA FORMOSA",
    "codsubpref": 26,
    "subpref": "ARICANDUVA",
    "regiao5": "Leste",
    "regiao8": "Leste 1",
    "nomeFeira": "PRAÇA LEÃO X",
    "registro": "7216-8",
    "logradouro": "RUA CODAJ-S",
    "numero": 45,
    "bairro": "VILA FORMOSA",
    "referencia": "PRAÇA MARECHAL LEITÃO BANDEIRA"
}
```

###Update existing fair

**URL:** PUT /{fairId}

**Status response:** 204 No Content

Body request example:
```
{
    "longitude": -46548146,
    "lagitude": -23568390,
    "setcens": 355030885000019,
    "areap": 3550308005040,
    "coddist": 87,
    "distrito": "VILA FORMOSA",
    "codsubpref": 26,
    "subpref": "ARICANDUVA",
    "regiao5": "Leste",
    "regiao8": "Leste 1",
    "nomeFeira": "PRAÃA LE+O X",
    "registro": "7216-8",
    "logradouro": "RUA CODAJ-S",
    "numero": 45,
    "bairro": "MOEMA",
    "referencia": "PRAÃA  MARECHAL LEIT+O BANDEIRA"
}
```

###Delete existing fair

**URL:** DELETE /{fairId}

**Status response:** 204 No Content