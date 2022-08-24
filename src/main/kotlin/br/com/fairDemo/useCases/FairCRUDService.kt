package br.com.fairDemo.useCases

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.useCases.utils.GetFairCriteria

interface FairCRUDService {

    fun create(newFair: Fair): Fair
    fun delete(fairId: Long): Boolean
    fun update(fairId: Long, fair: Fair): Fair
    fun getFairByCriteria(criteria: GetFairCriteria): List<Fair>
}