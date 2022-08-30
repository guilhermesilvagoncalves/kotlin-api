package br.com.fairDemo.infrastructure.database

import br.com.fairDemo.entities.Fair
import java.lang.Long.valueOf as toLong
import java.lang.Integer.valueOf as toInt
import java.math.BigInteger
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "fair")
class FairDAO (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var long: String,
    var lat: String,
    var setcens: String,
    var areap: String,
    var coddist: String,
    var distrito: String,
    var codsubpref: String,
    var subprefe: String,
    var regiao5: String,
    var regiao8: String,
    var nomeFeira: String,
    var registro: String,
    var logradouro: String,
    var numero: String? = "",
    var bairro: String? = "",
    var referencia: String? = ""
){
    constructor() : this(0,"","","","","","","","","","","","","","","","")

    fun toFairDomain(): Fair {
        return Fair(
            id =  this.id,
            longitude = BigInteger.valueOf(toLong(this.long)),
            latitude = BigInteger.valueOf(toLong(this.lat)),
            setcens = BigInteger.valueOf(toLong(this.setcens)),
            areap = BigInteger.valueOf(toLong(this.areap)),
            districtCode =  toInt(this.coddist),
            district = this.distrito,
            subPrefectureCode = toInt(this.codsubpref),
            subPrefectureName = this.subprefe,
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

    companion object{
        fun fromFairDomain(fair: Fair): FairDAO {
            return FairDAO(
                id = fair.id,
                long = fair.latitude.toString(),
                lat = fair.latitude.toString(),
                setcens = fair.setcens.toString(),
                areap = fair.areap.toString(),
                coddist = fair.districtCode.toString(),
                distrito = fair.district,
                codsubpref = fair.subPrefectureCode.toString(),
                subprefe = fair.subPrefectureName,
                regiao5 = fair.region5,
                regiao8 = fair.region8,
                nomeFeira = fair.fairName,
                registro = fair.register,
                logradouro = fair.publicPlace,
                numero = fair.number.toString(),
                bairro = fair.neighborhood,
                referencia = fair.reference
            )
        }
    }
}