package br.com.fairDemo.useCases

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.infrastructure.database.FairRepository
import br.com.fairDemo.useCases.errors.FairNotFound
import br.com.fairDemo.useCases.utils.FairValidation
import br.com.fairDemo.useCases.utils.GetFairCriteria
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException
import java.util.*

@Service

class FairCRUDServiceImpl(
    private val fairRepository: FairRepository,
    private val fairValidation: FairValidation
): FairCRUDService {
    override fun create(newFair: Fair): Fair {
        return fairRepository.save(newFair)
    }

    override fun delete(fairId: Long) {
        if (!fairValidation.isValid(fairId)) throw FairNotFound("Fair not found on database")
        fairRepository.deleteById(fairId)
    }

    override fun update(fairId: Long, fair: Fair) {
        fairRepository.findById(fairId)
            .map { record ->
                record.longitude = fair.longitude
                record.lagitude = fair.lagitude
                record.setcens = fair.setcens
                record.areap = fair.areap
                record.coddist = fair.coddist
                record.distrito = fair.distrito
                record.codsubpref = fair.codsubpref
                record.subpref = fair.subpref
                record.regiao5 = fair.regiao5
                record.regiao8 = fair.regiao8
                record.nomeFeira = fair.nomeFeira
                record.logradouro = fair.logradouro
                record.numero = fair.numero
                record.bairro = fair.bairro
                record.referencia = fair.referencia
                fairRepository.save(record)
            }.orElseThrow{ FairNotFound("Fair not found on database") }
    }

    override fun getFairByCriteria(criteria: GetFairCriteria): List<Fair> {
        return ArrayList()
    }

    private fun keepProtectedDataOnObject(incommingFair: Fair, savedFair: Fair): Fair {
        incommingFair.registro = savedFair.registro
        return incommingFair
    }
}