package br.com.fairDemo.infrastructure.http.controller

import br.com.fairDemo.infrastructure.services.ImportFileFromURL
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController("/fair")
class FairController (
    private val importFileFromURL: ImportFileFromURL
) {

    @GetMapping("/")
    fun helloWorld(): String{
        return "hello"
    }

    @PostMapping("/import-from-website")
    fun importFromWebSite(@RequestParam url: String){
        return importFileFromURL.execute(url)
    }

    @PostMapping("/")
    fun createFair(@RequestParam url: String){
        return importFileFromURL.execute(url)
    }

}