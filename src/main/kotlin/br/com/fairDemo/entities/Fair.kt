package br.com.fairDemo.entities

import java.math.BigInteger

data class Fair (
    val id: Long? = null,
    var longitude: BigInteger,
    var lagitude: BigInteger,
    var setcens: BigInteger,
    var areap: BigInteger,
    var coddist: Int,
    var distrito: String,
    var codsubpref: Int,
    var subpref: String,
    var regiao5: String,
    var regiao8: String,
    var nomeFeira: String,
    var registro: String,
    var logradouro: String,
    var numero: Int,
    var bairro: String,
    var referencia: String
){
    constructor() : this(null, BigInteger.valueOf(0),BigInteger.valueOf(0),BigInteger.valueOf(0),BigInteger.valueOf(0),0,"",0,"","","","","","",0,"","")
}