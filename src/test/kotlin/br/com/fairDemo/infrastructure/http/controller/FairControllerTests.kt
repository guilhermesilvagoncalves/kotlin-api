package br.com.fairDemo.infrastructure.http.controller

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.infrastructure.http.controller.createFair.CreateFairRequest
import br.com.fairDemo.infrastructure.http.controller.createFair.CreateFairResponse
import br.com.fairDemo.useCases.FairCRUDService
import br.com.fairDemo.useCases.ImportFileFromURL
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FairControllerTests {

	private val importFileFromURL: ImportFileFromURL = mockk()
	private val fairService: FairCRUDService = mockk()
	val controller = FairController(importFileFromURL, fairService)

	@Test
	fun shouldCallImportFileFromURLService(){
		every {importFileFromURL.execute("test") } returns Unit
		assertThat(
			controller.importFromWebSite("test"))
			.isInstanceOf(Unit::class.java)
	}

	@Test
	fun shouldCallFairServiceOnFairCreation(){
		val createFairRequest: CreateFairRequest = mockk()
		every { createFairRequest.toFairDomain() } returns getFairDomainForTests()
		every { fairService.create(getFairDomainForTests()) } returns getFairDomainForTests()
		controller.createFair(createFairRequest)
		verify(exactly = 1) { fairService.create(getFairDomainForTests()) }
	}

	@Test
	fun shouldReturnFairObjectOnResponseOfFairCreation(){
		val createFairRequest: CreateFairRequest = mockk()
		every { createFairRequest.toFairDomain() } returns getFairDomainForTests()
		every { fairService.create(getFairDomainForTests()) } returns getFairDomainForTests()
		assertThat(
			controller.createFair(createFairRequest))
			.isInstanceOf(CreateFairResponse::class.java)
	}

	private fun getFairDomainForTests(): Fair {
		return Fair(
			id = 1,
			longitude = -46548146,
			lagitude = -23568390,
			setcens = 355030885000019,
			areap = 3550308005040,
			coddist = 87,
			distrito = "VILA FORMOSA",
			codsubpref = 26,
			subpref = "ARICANDUVA",
			regiao5 = "Leste",
			regiao8 = "Leste 1",
			nomeFeira = "PRAÃA LE+O X",
			registro = "7216-8",
			logradouro = "RUA CODAJ-S",
			numero = 45,
			bairro = "VILA FORMOSA",
			referencia = "PRAÃA  MARECHAL LEIT+O BANDEIRA"
		)
	}

}
