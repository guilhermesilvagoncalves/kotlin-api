package br.com.fairDemo.infrastructure.database

import br.com.fairDemo.entities.Fair
import org.springframework.stereotype.Repository

@Repository
class FairRepositoryImp: FairRepository {
    override fun save(fair: Fair): Fair {
        //save object on database
        //return instance from database converted
        return fair
    }
}