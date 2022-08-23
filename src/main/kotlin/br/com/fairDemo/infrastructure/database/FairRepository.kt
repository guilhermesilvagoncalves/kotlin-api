package br.com.fairDemo.infrastructure.database

import br.com.fairDemo.entities.Fair

interface FairRepository {
    fun save(fair: Fair): Fair
}