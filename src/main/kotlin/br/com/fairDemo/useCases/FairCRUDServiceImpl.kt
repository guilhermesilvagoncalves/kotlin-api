package br.com.fairDemo.useCases

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.infrastructure.database.FairRepository
import br.com.fairDemo.useCases.utils.FairValidation
import org.springframework.stereotype.Service

@Service

class FairCRUDServiceImpl(
    private val fairRepository: FairRepository,
    private val fairValidation: FairValidation
): FairCRUDService {
    override fun create(newFair: Fair): Fair {
        return fairRepository.save(newFair)
    }

    override fun delete(fairId: Long): Boolean {
        //TODO: delete based on id
        return true
    }
}