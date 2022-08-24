package br.com.fairDemo.infrastructure.http.controller.getFair

import br.com.fairDemo.useCases.utils.GetFairCriteria

data class GetFairFilter (
    val distrito: String = "",
    val regiao5: String = "",
    val nomeFeira: String = "",
    val bairro: String = ""
) {
    fun toFairCriteria(): GetFairCriteria {
        return GetFairCriteria(
            distrito = this.distrito,
            regiao5 = this.regiao5,
            nomeFeira = this.nomeFeira,
            bairro = this.bairro
        )
    }
}