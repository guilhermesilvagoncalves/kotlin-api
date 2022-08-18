package br.com.fairDemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FairDemoApplication

fun main(args: Array<String>) {
	runApplication<FairDemoApplication>(*args)
}
