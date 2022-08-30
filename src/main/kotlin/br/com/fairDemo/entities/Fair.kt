package br.com.fairDemo.entities

import java.math.BigInteger

data class Fair (
    val id: Long? = null,
    var longitude: BigInteger,
    var latitude: BigInteger,
    var setcens: BigInteger,
    var areap: BigInteger,
    var districtCode: Int,
    var district: String,
    var subPrefectureCode: Int,
    var subPrefectureName: String,
    var region5: String,
    var region8: String,
    var fairName: String,
    var register: String,
    var publicPlace: String,
    var number: String? = "",
    var neighborhood: String? = "",
    var reference: String? = ""
){
    constructor() : this(null, BigInteger.valueOf(0),BigInteger.valueOf(0),BigInteger.valueOf(0),BigInteger.valueOf(0),0,"",0,"","","","","","","","","")
}