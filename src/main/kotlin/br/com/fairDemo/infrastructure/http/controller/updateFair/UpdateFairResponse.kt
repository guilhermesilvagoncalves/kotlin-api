package br.com.fairDemo.infrastructure.http.controller.updateFair

import br.com.fairDemo.entities.Fair

data class UpdateFairResponse (
    val id: Long?,
    val longitude: Long,
    val lagitude: Long,
    val setcens: Long,
    val areap: Long,
    val coddist: Long,
    val distrito: String,
    val codsubpref: Long,
    val subpref: String,
    val regiao5: String,
    val regiao8: String,
    val nomeFeira: String,
    val registro: String,
    val logradouro: String,
    val numero: Long,
    val bairro: String,
    val referencia: String
) {
    companion object{
        fun fromFairDomain(fair: Fair): UpdateFairResponse {
            return UpdateFairResponse(
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