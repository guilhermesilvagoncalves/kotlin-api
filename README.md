# kotlin-api-example

## How to run application

./mvnw clean install
./mvnw spring-boot:run

## How to run tests

./mvnw test

## Endpoints

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
    "nomeFeira": "PRAÃA LE+O X",
    "registro": "7216-8",
    "logradouro": "RUA CODAJ-S",
    "numero": 45,
    "bairro": "VILA FORMOSA",
    "referencia": "PRAÃA  MARECHAL LEIT+O BANDEIRA"
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