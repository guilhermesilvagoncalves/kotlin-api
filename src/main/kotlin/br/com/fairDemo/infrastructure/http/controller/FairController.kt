package br.com.fairDemo.infrastructure.http.controller

import br.com.fairDemo.infrastructure.http.controller.createFair.CreateFairRequest
import br.com.fairDemo.infrastructure.http.controller.createFair.CreateFairResponse
import br.com.fairDemo.infrastructure.http.controller.createFair.CreateFairResponse.Companion.fromFairDomain
import br.com.fairDemo.useCases.FairCRUDService
import br.com.fairDemo.useCases.ImportFileFromURL
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController("/fair")
class FairController (
    private val importFileFromURL: ImportFileFromURL,
    private val fairServices: FairCRUDService
) {

    @GetMapping("/")
    fun helloWorld(): String{
        return "hello"
    }

    @PostMapping("/import-from-website")
    fun importFromWebSite(@RequestParam url: String){
        return importFileFromURL.execute(url)
    }

    @PostMapping("/", consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createFair(@RequestBody fairRequest: CreateFairRequest): CreateFairResponse {
        val newFair = fairRequest.toFairDomain()
        return fromFairDomain(fairServices.create(newFair))
    }

}