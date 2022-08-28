package br.com.fairDemo.infrastructure.http.controller.getFair

import br.com.fairDemo.entities.Fair
import java.math.BigInteger

class GetFairsResponse (
    val id: String = "",
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
        companion object{
            fun fromFairDomain(fair: Fair): GetFairsResponse {
                return GetFairsResponse(
                    id = fair.id.toString(),
                    longitude = fair.longitude,
                    lagitude = fair.lagitude,
                    setcens = fair.setcens,
                    areap = fair.areap,
                    coddist = fair.coddist,
                    distrito = fair.distrito,
                    codsubpref = fair.codsubpref,
                    subpref = fair.subpref,
                    regiao5 = fair.regiao5,
                    regiao8 = fair.regiao8,
                    nomeFeira = fair.nomeFeira,
                    registro = fair.registro,
                    logradouro = fair.logradouro,
                    numero = fair.numero,
                    bairro = fair.bairro,
                    referencia = fair.referencia
                )
            }
        }
}
