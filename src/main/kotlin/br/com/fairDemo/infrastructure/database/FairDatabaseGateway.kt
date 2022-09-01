package br.com.fairDemo.infrastructure.database

import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FairDatabaseGateway: CrudRepository<FairDAO, Long>, JpaSpecificationExecutor<FairDAO> {
}