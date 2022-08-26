package br.com.fairDemo.fixtures

import br.com.fairDemo.infrastructure.http.controller.getFair.GetFairFilter

class GetFairFilterFixture {
    companion object{
        fun getGetFairFilterForTest(): GetFairFilter{
            return GetFairFilter(
                    distrito = "VILA FORMOSA",
                    regiao5 = "Leste",
                    nomeFeira = "PRAÃA LE+O X",
                    bairro = "VILA FORMOSA",
                )
        }
    }
}