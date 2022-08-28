package br.com.fairDemo.infrastructure.database

import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.awt.print.Book
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.criteria.CriteriaBuilder
import javax.persistence.criteria.Predicate
import javax.persistence.criteria.Root

@Repository
interface FairRepository: CrudRepository<FairDAO, Long>, JpaSpecificationExecutor<FairDAO> {
}