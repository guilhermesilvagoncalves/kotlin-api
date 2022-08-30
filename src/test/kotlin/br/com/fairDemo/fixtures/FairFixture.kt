package br.com.fairDemo.fixtures

import br.com.fairDemo.entities.Fair
import java.math.BigInteger

class FairFixture {
    companion object{
        fun getFairDomainForTests(): Fair {
            return Fair(
                id = 1,
                longitude = BigInteger.valueOf(-46548146),
                latitude = BigInteger.valueOf(-23568390),
                setcens = BigInteger.valueOf(355030885000019),
                areap = BigInteger.valueOf(3550308005040),
                districtCode = 87,
                district = "VILA FORMOSA",
                subPrefectureCode = 26,
                subPrefectureName = "ARICANDUVA",
                region5 = "Leste",
                region8 = "Leste 1",
                fairName = "PRAÃA LE+O X",
                register = "7216-8",
                publicPlace = "RUA CODAJ-S",
                number = "45",
                neighborhood = "VILA FORMOSA",
                reference = "PRAÃA  MARECHAL LEIT+O BANDEIRA"
            )
        }
    }

}