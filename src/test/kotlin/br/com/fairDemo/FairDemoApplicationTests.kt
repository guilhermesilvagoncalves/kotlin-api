package br.com.fairDemo

import br.com.fairDemo.controller.FairController
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FairDemoApplicationTests {

	@Test
	fun contextLoads() {
	}

	@Test
	fun shouldReturnHelloWorld(){
		val controller = FairController ()
		assert(controller.helloWorld() == "hello")
	}

}
