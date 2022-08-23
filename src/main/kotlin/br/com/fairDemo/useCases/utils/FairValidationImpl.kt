package br.com.fairDemo.useCases.utils

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.infrastructure.database.FairRepository
import org.springframework.stereotype.Service

@Service
class FairValidationImpl(
    private val fairRepository: FairRepository
): FairValidation {
    override fun isValid(fairId: Long): Boolean{
        if (checkIfExists(fairId) == null)
            return false
        return true
    }

    private fun checkIfExists(fairId: Long): Fair? {
        return fairRepository.findBy(fairId)
    }
}
