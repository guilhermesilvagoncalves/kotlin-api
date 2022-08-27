package br.com.fairDemo.fixtures

import br.com.fairDemo.entities.Fair
import java.math.BigInteger

class FairFixture {
    companion object{
        fun getFairDomainForTests(): Fair {
            return Fair(
                id = 1,
                longitude = BigInteger.valueOf(-46548146),
                lagitude = BigInteger.valueOf(-23568390),
                setcens = BigInteger.valueOf(355030885000019),
                areap = BigInteger.valueOf(3550308005040),
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