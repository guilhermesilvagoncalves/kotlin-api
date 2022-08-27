package br.com.fairDemo.infrastructure.database

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FairRepository: CrudRepository<FairDAO, Long> {
}