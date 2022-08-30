package br.com.fairDemo.infrastructure.http.controller.getFair

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.infrastructure.http.controller.createFair.CreateFairResponse
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigInteger

class GetFairsResponse (
    @JsonProperty("id")
    val id: Long?,
    @JsonProperty("longitude")
    val longitude: BigInteger,
    @JsonProperty("lagitude")
    val latitude: BigInteger,
    @JsonProperty("setcens")
    val setcens: BigInteger,
    @JsonProperty("areap")
    val areap: BigInteger,
    @JsonProperty("coddist")
    val districtCode: Int,
    @JsonProperty("distrito")
    val district: String,
    @JsonProperty("codsubpref")
    val subPrefectureCode: Int,
    @JsonProperty("subpref")
    val subPrefectureName: String,
    @JsonProperty("regiao5")
    val region5: String,
    @JsonProperty("regiao8")
    val region8: String,
    @JsonProperty("nomeFeira")
    val fairName: String,
    @JsonProperty("registro")
    val register: String,
    @JsonProperty("logradouro")
    val publicPlace: String,
    @JsonProperty("numero")
    val number: String? = "",
    @JsonProperty("bairro")
    val neighborhood: String? = "",
    @JsonProperty("referencia")
    val reference: String? = ""
) {
    companion object {
        fun fromFairDomain(fair: Fair): GetFairsResponse {
            return GetFairsResponse(
                id = fair.id,
                longitude = fair.longitude,
                latitude = fair.latitude,
                setcens = fair.setcens,
                areap = fair.areap,
                districtCode = fair.districtCode,
                district = fair.district,
                subPrefectureCode = fair.subPrefectureCode,
                subPrefectureName = fair.subPrefectureName,
                region5 = fair.region5,
                region8 = fair.region8,
                fairName = fair.fairName,
                register = fair.register,
                publicPlace = fair.publicPlace,
                number = fair.number,
                neighborhood = fair.neighborhood,
                reference = fair.reference
            )
        }
    }}
