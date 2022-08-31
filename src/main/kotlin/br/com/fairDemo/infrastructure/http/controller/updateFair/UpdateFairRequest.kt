package br.com.fairDemo.infrastructure.http.controller.updateFair

import br.com.fairDemo.entities.Fair
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigInteger

data class UpdateFairRequest (
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
    fun toFairDomain(): Fair {
        return Fair(
            longitude = this.longitude,
            latitude = this.latitude,
            setcens = this.setcens,
            areap = this.areap,
            districtCode = this.districtCode,
            district = this.district,
            subPrefectureCode = this.subPrefectureCode,
            subPrefectureName = this.subPrefectureName,
            region5 = this.region5,
            region8 = this.region8,
            fairName = this.fairName,
            register = this.register,
            publicPlace = this.publicPlace,
            number = this.number,
            neighborhood = this.neighborhood,
            reference = this.reference
        )
    }
}