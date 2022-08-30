package br.com.fairDemo.fixtures

import br.com.fairDemo.infrastructure.http.controller.getFair.GetFairFilter

class GetFairFilterFixture {
    companion object{
        fun getGetFairFilterForTest(): GetFairFilter{
            return GetFairFilter(
                    distrito = "",
                    regiao5 = "",
                    nomeFeira = "",
                    bairro = "",
                )
        }
    }
}