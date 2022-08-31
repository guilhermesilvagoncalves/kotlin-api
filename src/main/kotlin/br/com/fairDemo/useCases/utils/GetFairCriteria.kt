package br.com.fairDemo.useCases.utils

data class GetFairCriteria (
    val district: String? = "",
    val region5: String? = "",
    val fairName: String? = "",
    val neighborhood: String? = ""
)