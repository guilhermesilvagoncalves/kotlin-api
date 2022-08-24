package br.com.fairDemo.infrastructure.database

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.useCases.utils.GetFairCriteria
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class FairRepositoryImp: FairRepository {
    override fun save(fair: Fair): Fair {
        //TODO: save object on database
        //TODO: return instance from database converted
        return fair
    }

    override fun delete(fairId: Long) {
        //TODO: delete object on database based on id
        //TODO: return true or false for operation
    }

    override fun findBy(fairId: Long): Fair? {
        //TODO: remove this object
        return Fair(
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

    override fun findBy(criteria: GetFairCriteria): List<Fair>{
        //TODO: find considering criterias
        val fair = Fair(
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
        val list = ArrayList<Fair>()
        list.add(fair)
        return list
    }
}