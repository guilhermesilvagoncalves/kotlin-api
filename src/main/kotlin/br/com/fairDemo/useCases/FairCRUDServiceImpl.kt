package br.com.fairDemo.useCases

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.infrastructure.database.FairDAO.Companion.fromFairDomain
import br.com.fairDemo.infrastructure.database.FairRepository
import br.com.fairDemo.useCases.errors.FairNotFound
import br.com.fairDemo.useCases.utils.FairValidation
import br.com.fairDemo.useCases.utils.GetFairCriteria
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import java.util.stream.StreamSupport

@Service

class FairCRUDServiceImpl(
    private val fairRepository: FairRepository,
    private val fairValidation: FairValidation
): FairCRUDService {
    override fun create(newFair: Fair): Fair {
        return fairRepository.save(
            fromFairDomain(newFair))
            .toFairDomain()
    }

    override fun delete(fairId: Long) {
        if (!fairValidation.isValid(fairId)) throw FairNotFound("Fair not found on database")
        fairRepository.deleteById(fairId)
    }

    override fun update(fairId: Long, fair: Fair) {
        fairRepository.findById(fairId)
            .map { record ->
                record.long = fair.longitude.toString()
                record.lat = fair.latitude.toString()
                record.setcens = fair.setcens.toString()
                record.areap = fair.areap.toString()
                record.coddist = fair.districtCode.toString()
                record.distrito = fair.district
                record.codsubpref = fair.subPrefectureCode.toString()
                record.subprefe = fair.subPrefectureName
                record.regiao5 = fair.region5
                record.regiao8 = fair.region8
                record.nomeFeira = fair.fairName
                record.logradouro = fair.publicPlace
                record.numero = fair.number.toString()
                record.bairro = fair.neighborhood
                record.referencia = fair.reference
                fairRepository.save(record)
            }.orElseThrow{ FairNotFound("Fair not found on database") }
    }

    override fun getFairByCriteria(criteria: GetFairCriteria): List<Fair> {
        return StreamSupport.stream(
            fairRepository.findAll().spliterator(), false)
            .collect(Collectors.toList())
            .stream()
            .map { fairDAO -> fairDAO.toFairDomain() }
            .filter{ fair -> if (isNotEmpty(criteria.district)) fair.district == criteria.district else true }
            .filter{ fair -> if (isNotEmpty(criteria.region5)) fair.region5 == criteria.region5 else true }
            .filter{ fair -> if (isNotEmpty(criteria.fairName)) fair.fairName == criteria.fairName else true }
            .filter{ fair -> if (isNotEmpty(criteria.neighborhood)) fair.neighborhood == criteria.neighborhood else true }
            .toList()
    }

    private fun isNotEmpty(field: String?): Boolean {
        return field != null && field != ""
    }

}