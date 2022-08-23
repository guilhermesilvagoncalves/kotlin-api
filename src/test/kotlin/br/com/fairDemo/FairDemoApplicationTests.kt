package br.com.fairDemo

import br.com.fairDemo.infrastructure.http.controller.FairController
import br.com.fairDemo.useCases.FairCRUDServiceImpl
import br.com.fairDemo.useCases.ImportFileFromURL
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FairDemoApplicationTests {

	private val importFileFromURL: ImportFileFromURL = mockk()
	private val fairService: FairCRUDServiceImpl = mockk()
	val controller = FairController(importFileFromURL, fairService)

	@Test
	fun shouldReturnHelloWorld(){
		assertThat(
			controller.helloWorld())
			.isEqualTo("hello")
	}
}
