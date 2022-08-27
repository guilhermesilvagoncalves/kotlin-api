package br.com.fairDemo.infrastructure.database

import br.com.fairDemo.entities.Fair
import java.lang.Long.valueOf as toLong
import java.lang.Integer.valueOf as toInt
import java.math.BigInteger
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "fair")
class FairDAO (
    @Id
    @SequenceGenerator(
        name = "fair_sequence",
        sequenceName = "fair_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        generator = "fair_sequence",
        strategy = GenerationType.SEQUENCE
    )
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
    var numero: String,
    var bairro: String,
    var referencia: String
){
    constructor() : this(0,"","","","","","","","","","","","","","","","")

    fun toFairDomain(): Fair {
        return Fair(
            id =  this.id,
            longitude = BigInteger.valueOf(toLong(this.long)),
            lagitude = BigInteger.valueOf(toLong(this.lat)),
            setcens = BigInteger.valueOf(toLong(this.setcens)),
            areap = BigInteger.valueOf(toLong(this.areap)),
            coddist =  toInt(this.coddist),
            distrito = this.distrito,
            codsubpref = toInt(this.codsubpref),
            subpref = this.subprefe,
            regiao5 = this.regiao5,
            regiao8 = this.regiao8,
            nomeFeira = this.nomeFeira,
            registro = this.registro,
            logradouro = this.logradouro,
            numero = toInt(this.numero),
            bairro = this.bairro,
            referencia = this.referencia
        )
    }

    companion object{
        fun fromFairDomain(fair: Fair): FairDAO {
            return FairDAO(
                id = fair.id,
                long = fair.lagitude.toString(),
                lat = fair.lagitude.toString(),
                setcens = fair.setcens.toString(),
                areap = fair.areap.toString(),
                coddist = fair.coddist.toString(),
                distrito = fair.distrito,
                codsubpref = fair.codsubpref.toString(),
                subprefe = fair.subpref,
                regiao5 = fair.regiao5,
                regiao8 = fair.regiao8,
                nomeFeira = fair.nomeFeira,
                registro = fair.registro,
                logradouro = fair.logradouro,
                numero = fair.numero.toString(),
                bairro = fair.bairro,
                referencia = fair.referencia
            )
        }
    }
}