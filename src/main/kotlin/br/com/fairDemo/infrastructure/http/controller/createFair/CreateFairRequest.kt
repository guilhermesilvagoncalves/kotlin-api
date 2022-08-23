package br.com.fairDemo.infrastructure.http.controller.createFair

import br.com.fairDemo.entities.Fair

data class CreateFairRequest (
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
) {
    fun toFairDomain(): Fair {
        return Fair(
        id = this.id,
        longitude = this.longitude,
        lagitude = this.lagitude,
        setcens = this.setcens,
        areap = this.areap,
        coddist = this.coddist,
        distrito = this.distrito,
        codsubpref = this.codsubpref,
        subpref = this.subpref,
        regiao5 = this.regiao5,
        regiao8 = this.regiao8,
        nomeFeira = this.nomeFeira,
        registro = this.registro,
        logradouro = this.logradouro,
        numero = this.numero,
        bairro = this.bairro,
        referencia = this.referencia
        )
    }
}