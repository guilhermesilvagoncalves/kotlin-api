package br.com.fairDemo.useCases

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.infrastructure.database.FairRepository
import br.com.fairDemo.useCases.utils.FairValidation
import br.com.fairDemo.useCases.utils.GetFairCriteria
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
        if (fairValidation.isValid(fairId)) return false
        fairRepository.delete(fairId)
        return true
    }

    override fun update(fairId: Long, fair: Fair): Fair {
        val fairFromDatabase: Fair? = fairRepository.findBy(fairId)
        if (fairFromDatabase == null){
            //TODO: return error
        }
        val fairToUpdate = keepProtectedDataOnObject(fair, fairFromDatabase!!)
        fairRepository.save(fairToUpdate)
        return fair
    }

    override fun getFairByCriteria(criteria: GetFairCriteria): List<Fair> {
        return fairRepository.findBy(criteria)
    }

    private fun keepProtectedDataOnObject(incommingFair: Fair, savedFair: Fair): Fair {
        incommingFair.registro = savedFair.registro
        return incommingFair
    }
}