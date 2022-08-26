package br.com.fairDemo.useCases

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.useCases.utils.GetFairCriteria

interface FairCRUDService {

    fun create(newFair: Fair): Fair
    fun delete(fairId: Long)
    fun update(fairId: Long, fair: Fair)
    fun getFairByCriteria(criteria: GetFairCriteria): List<Fair>
}