package br.com.fairDemo.infrastructure.http.controller.getFair

import br.com.fairDemo.useCases.utils.GetFairCriteria

data class GetFairFilter (
    val district: String = "",
    val region5: String = "",
    val fairName: String = "",
    val neighborhood: String = ""
) {
    fun toFairCriteria(): GetFairCriteria {
        return GetFairCriteria(
            distrito = this.district,
            regiao5 = this.region5,
            nomeFeira = this.fairName,
            bairro = this.neighborhood
        )
    }
}