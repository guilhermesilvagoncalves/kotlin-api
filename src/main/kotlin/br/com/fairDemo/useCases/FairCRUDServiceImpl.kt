package br.com.fairDemo.useCases

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.infrastructure.database.FairDAO
import br.com.fairDemo.infrastructure.database.FairDAO.Companion.fromFairDomain
import br.com.fairDemo.infrastructure.database.FairRepository
import br.com.fairDemo.useCases.errors.FairNotFound
import br.com.fairDemo.useCases.utils.FairValidation
import br.com.fairDemo.useCases.utils.GetFairCriteria
import org.springframework.stereotype.Service
import java.awt.print.Book
import java.util.*
import java.util.stream.Collectors
import java.util.stream.StreamSupport
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.Root


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
                record.lat = fair.lagitude.toString()
                record.setcens = fair.setcens.toString()
                record.areap = fair.areap.toString()
                record.coddist = fair.coddist.toString()
                record.distrito = fair.distrito
                record.codsubpref = fair.codsubpref.toString()
                record.subprefe = fair.subpref
                record.regiao5 = fair.regiao5
                record.regiao8 = fair.regiao8
                record.nomeFeira = fair.nomeFeira
                record.logradouro = fair.logradouro
                record.numero = fair.numero.toString()
                record.bairro = fair.bairro
                record.referencia = fair.referencia
                fairRepository.save(record)
            }.orElseThrow{ FairNotFound("Fair not found on database") }
    }

    override fun getFairByCriteria(criteria: GetFairCriteria): MutableList<Fair> {
        return StreamSupport.stream(
            fairRepository.findAll().spliterator(), false)
            .collect(Collectors.toList())
            .stream()
            .map { fairDAO -> fairDAO.toFairDomain() }
            .filter{ fair -> if (isNotEmpty(criteria.distrito)) fair.distrito == criteria.distrito else true }
            .filter{ fair -> if (isNotEmpty(criteria.regiao5)) fair.regiao5 == criteria.regiao5 else true }
            .filter{ fair -> if (isNotEmpty(criteria.nomeFeira)) fair.nomeFeira == criteria.nomeFeira else true }
            .filter{ fair -> if (isNotEmpty(criteria.bairro)) fair.bairro == criteria.bairro else true }
            .toList()
    }

    private fun isNotEmpty(field: String?): Boolean {
        return field != null && field != ""
    }

}