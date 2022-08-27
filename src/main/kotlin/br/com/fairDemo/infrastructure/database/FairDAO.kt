package br.com.fairDemo.infrastructure.database

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.infrastructure.http.controller.createFair.CreateFairResponse
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class FairDAO (
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null,
    var longitude: Long,
    var lagitude: Long,
    var setcens: Long,
    var areap: Long,
    var coddist: Long,
    var distrito: String,
    var codsubpref: Long,
    var subpref: String,
    var regiao5: String,
    var regiao8: String,
    var nomeFeira: String,
    var registro: String,
    var logradouro: String,
    var numero: Long,
    var bairro: String,
    var referencia: String
){
    constructor() : this(0,0,0,0,0,0,"",0,"","","","","","",0,"","")

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

    companion object{
        fun fromFairDomain(fair: Fair): FairDAO {
            return FairDAO(
                id = fair.id,
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