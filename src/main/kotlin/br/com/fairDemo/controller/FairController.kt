package br.com.fairDemo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FairController {

    @GetMapping("/")
    fun helloWorld(): String{
        return "hello"
    }

}