package br.com.fairDemo.infrastructure.database

import br.com.fairDemo.entities.Fair
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FairRepository: CrudRepository<Fair, Long> {
}