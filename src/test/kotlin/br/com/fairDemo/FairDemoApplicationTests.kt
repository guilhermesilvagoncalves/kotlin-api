package br.com.fairDemo

import br.com.fairDemo.controller.FairController
import br.com.fairDemo.useCases.ImportFileFromURLImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FairDemoApplicationTests {

	private val importFileFromURL: ImportFileFromURLImpl = mock(ImportFileFromURLImpl::class.java)
	val controller = FairController(importFileFromURL)

	@Test
	fun shouldReturnHelloWorld(){
		assertThat(
			controller.helloWorld())
			.isEqualTo("hello")
	}

	@Test
	fun shouldCallImportFileFromURLService(){
		assertThat(
			controller.importFromWebSite("test"))
			.isInstanceOf(Unit::class.java)
	}

}
