package br.com.fairDemo.entities

data class Fair (
    val id: Long,
    val longitude: Long,
    val lagitude: Long,
    val setcens: Long,
    val areap: Long,
    val coddist: Long,
    val distrito: String,
    val codsubpref: Long,
    val subpref: String,
    val regiao5: String,
    val regiao8: String,
    val nomeFeira: String,
    val registro: String,
    val logradouro: String,
    val numero: Long,
    val bairro: String,
    val referencia: String
){

}