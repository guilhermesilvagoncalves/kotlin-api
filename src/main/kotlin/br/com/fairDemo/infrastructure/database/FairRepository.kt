package br.com.fairDemo.infrastructure.database

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.useCases.utils.GetFairCriteria

interface FairRepository {
    fun save(fair: Fair): Fair
    fun delete(fairId: Long)
    fun findBy(fairId: Long): Fair?
    fun findBy(criteria: GetFairCriteria): List<Fair>
}