package br.com.fairDemo.infrastructure.http.controller.createFair

import br.com.fairDemo.entities.Fair
import java.math.BigInteger

data class CreateFairRequest (
    val longitude: BigInteger,
    val lagitude: BigInteger,
    val setcens: BigInteger,
    val areap: BigInteger,
    val coddist: Int,
    val distrito: String,
    val codsubpref: Int,
    val subpref: String,
    val regiao5: String,
    val regiao8: String,
    val nomeFeira: String,
    val registro: String,
    val logradouro: String,
    val numero: String? = "",
    val bairro: String? = "",
    val referencia: String? = ""
) {
    fun toFairDomain(): Fair {
        return Fair(
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