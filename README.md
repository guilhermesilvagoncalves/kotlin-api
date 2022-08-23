# kotlin-api-example

## How to run application

./mvnw clean install
./mvnw spring-boot:run

## How to run tests

./mvnw test

## Endpoints

hello world: /

**create new fair: POST /** 

Body request example:
```
{
    "id": 1,
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
    "bairro": "VILA FORMOSA",
    "referencia": "PRAÃA  MARECHAL LEIT+O BANDEIRA"
}
```