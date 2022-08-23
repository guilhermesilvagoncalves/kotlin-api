package br.com.fairDemo.useCases

import br.com.fairDemo.entities.Fair

interface FairCRUDService {

    fun create(newFair: Fair): Fair
}