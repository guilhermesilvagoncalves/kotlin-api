package br.com.fairDemo.fixtures

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.infrastructure.database.FairDAO

class FairDAOFixture {
    companion object{
        fun getFairDAODomainForTests(): FairDAO {
            return FairDAO(
                id = 1,
                longitude = -46548146,
                lagitude = -23568390,
                setcens = 355030885000019,
                areap = 3550308005040,
                coddist = 87,
                distrito = "VILA FORMOSA",
                codsubpref = 26,
                subpref = "ARICANDUVA",
                regiao5 = "Leste",
                regiao8 = "Leste 1",
                nomeFeira = "PRAÃA LE+O X",
                registro = "7216-8",
                logradouro = "RUA CODAJ-S",
                numero = 45,
                bairro = "VILA FORMOSA",
                referencia = "PRAÃA  MARECHAL LEIT+O BANDEIRA"
            )
        }
    }

}