package br.com.fairDemo.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Fair (
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    var longitude: Long,
    var lagitude: Long,
    var setcens: Long,
    var areap: Long,
    var coddist: Long,
    var distrito: String,
    var codsubpref: Long,
    var subpref: String,
    var regiao5: String,
    var regiao8: String,
    var nomeFeira: String,
    var registro: String,
    var logradouro: String,
    var numero: Long,
    var bairro: String,
    var referencia: String
){
    constructor() : this(0,0,0,0,0,0,"",0,"","","","","","",0,"","")
}