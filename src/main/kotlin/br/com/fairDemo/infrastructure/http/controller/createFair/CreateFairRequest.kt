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
            latitude = this.lagitude,
            setcens = this.setcens,
            areap = this.areap,
            districtCode = this.coddist,
            district = this.distrito,
            subPrefectureCode = this.codsubpref,
            subPrefectureName = this.subpref,
            region5 = this.regiao5,
            region8 = this.regiao8,
            fairName = this.nomeFeira,
            register = this.registro,
            publicPlace = this.logradouro,
            number = this.numero,
            neighborhood = this.bairro,
            reference = this.referencia
        )
    }
}