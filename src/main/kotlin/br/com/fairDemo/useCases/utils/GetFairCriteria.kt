package br.com.fairDemo.useCases.utils

data class GetFairCriteria (
    val distrito: String? = "",
    val regiao5: String? = "",
    val nomeFeira: String? = "",
    val bairro: String? = ""
) {
    fun hasParameter(): Boolean {
        return isNotEmpty(distrito) ||
                isNotEmpty(regiao5) ||
                isNotEmpty(nomeFeira) ||
                isNotEmpty(bairro)
    }

    private fun isNotEmpty(field: String?): Boolean {
        return field != null && field != ""
    }
}