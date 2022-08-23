package br.com.fairDemo.infrastructure.http.controller

import br.com.fairDemo.fixtures.FairFixture
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
		every { createFairRequest.toFairDomain() } returns FairFixture.getFairDomainForTests()
		every { fairService.create(FairFixture.getFairDomainForTests()) } returns FairFixture.getFairDomainForTests()
		controller.createFair(createFairRequest)
		verify(exactly = 1) { fairService.create(FairFixture.getFairDomainForTests()) }
	}

	@Test
	fun shouldReturnFairObjectOnResponseOfFairCreation(){
		val createFairRequest: CreateFairRequest = mockk()
		every { createFairRequest.toFairDomain() } returns FairFixture.getFairDomainForTests()
		every { fairService.create(FairFixture.getFairDomainForTests()) } returns FairFixture.getFairDomainForTests()
		assertThat(
			controller.createFair(createFairRequest))
			.isInstanceOf(CreateFairResponse::class.java)
	}

	@Test
	fun shouldCallFairServiceOnFairDeletion(){
		val fairId = FairFixture.getFairDomainForTests().id
		every { fairService.delete(fairId) } returns true
		controller.deleteFair(fairId)
		verify(exactly = 1) { fairService.delete(fairId) }
	}

	@Test
	fun shouldReturnNoContentOnResponseOfFairDeletionCreation(){
		val fairId = FairFixture.getFairDomainForTests().id
		every { fairService.delete(fairId) } returns true
		assertThat(
			controller.deleteFair(fairId))
			.isInstanceOf(Unit::class.java)
	}

}
