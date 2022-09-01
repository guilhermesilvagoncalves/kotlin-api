package br.com.fairDemo.useCases.utils

import br.com.fairDemo.infrastructure.database.FairDatabaseGateway
import org.springframework.stereotype.Service

@Service
class FairValidationImpl(
    private val fairRepository: FairDatabaseGateway
): FairValidation {
    override fun isValid(fairId: Long): Boolean{
        return fairRepository.findById(fairId).isPresent
    }
}
