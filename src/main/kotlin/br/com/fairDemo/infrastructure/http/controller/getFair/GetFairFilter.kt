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
            district = this.district,
            region5 = this.region5,
            fairName = this.fairName,
            neighborhood = this.neighborhood
        )
    }
}