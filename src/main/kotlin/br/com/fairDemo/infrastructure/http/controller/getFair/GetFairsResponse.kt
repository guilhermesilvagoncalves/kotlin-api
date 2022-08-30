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
                    lagitude = fair.latitude,
                    setcens = fair.setcens,
                    areap = fair.areap,
                    coddist = fair.districtCode,
                    distrito = fair.district,
                    codsubpref = fair.subPrefectureCode,
                    subpref = fair.subPrefectureName,
                    regiao5 = fair.region5,
                    regiao8 = fair.region8,
                    nomeFeira = fair.fairName,
                    registro = fair.register,
                    logradouro = fair.publicPlace,
                    numero = fair.number,
                    bairro = fair.neighborhood,
                    referencia = fair.reference
                )
            }
        }
}
