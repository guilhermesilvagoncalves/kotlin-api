package br.com.fairDemo.useCases

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.infrastructure.database.FairRepository
import org.springframework.stereotype.Service

@Service

class FairCRUDServiceImpl(
    private val fairRepository: FairRepository
): FairCRUDService {
    override fun create(newFair: Fair): Fair {
        return fairRepository.save(newFair)
    }
}