package br.com.fairDemo.infrastructure.http.controller

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.fixtures.FairFixture
import br.com.fairDemo.fixtures.GetFairFilterFixture
import br.com.fairDemo.infrastructure.http.controller.createFair.CreateFairRequest
import br.com.fairDemo.infrastructure.http.controller.createFair.CreateFairResponse
import br.com.fairDemo.infrastructure.http.controller.getFair.GetFairFilter
import br.com.fairDemo.infrastructure.http.controller.getFair.GetFairsResponse
import br.com.fairDemo.infrastructure.http.controller.updateFair.UpdateFairRequest
import br.com.fairDemo.infrastructure.http.controller.updateFair.UpdateFairResponse
import br.com.fairDemo.useCases.FairCRUDService
import br.com.fairDemo.useCases.ImportFileFromURL
import br.com.fairDemo.useCases.utils.GetFairCriteria
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.ResponseEntity
import java.util.*

@SpringBootTest
class FairControllerTests {

	private val importFileFromURL: ImportFileFromURL = mockk()
	private val fairService: FairCRUDService = mockk()
	val controller = FairController(importFileFromURL, fairService)

	private val getFairFilter: GetFairFilter = GetFairFilterFixture.getGetFairFilterForTest()
	private val getFairCriteria: GetFairCriteria = getFairFilter.toFairCriteria()
	private val fair: Fair = FairFixture.getFairDomainForTests()

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
			.isInstanceOf(ResponseEntity::class.java)
	}

	@Test
	fun shouldCallFairServiceOnFairDeletion(){
		val fairId = FairFixture.getFairDomainForTests().id!!
		every { fairService.delete(fairId) } returns Unit
		controller.deleteFair(fairId)
		verify(exactly = 1) { fairService.delete(fairId) }
	}

	@Test
	fun shouldReturnNoContentOnResponseOfFairDeletionCreation(){
		val fairId = FairFixture.getFairDomainForTests().id!!
		every { fairService.delete(fairId) } returns Unit
		assertThat(
			controller.deleteFair(fairId))
			.isInstanceOf(ResponseEntity::class.java)
	}

	@Test
	fun shouldReturnFairObjectOnResponseOfFairUpdate(){
		val updateFairRequest: UpdateFairRequest = mockk()
		val fairId: Long = FairFixture.getFairDomainForTests().id!!
		val fair = FairFixture.getFairDomainForTests()
		every { updateFairRequest.toFairDomain() } returns fair
		every { fairService.update(fairId, updateFairRequest.toFairDomain()) } returns Unit
		assertThat(
			controller.updateFair(fairId, updateFairRequest))
			.isInstanceOf(ResponseEntity::class.java)
	}

	@Test
	fun shouldCallFairServiceOnFairUpdate(){
		val updateFairRequest: UpdateFairRequest = mockk()
		val fairId: Long = FairFixture.getFairDomainForTests().id!!
		val fair = FairFixture.getFairDomainForTests()
		every { updateFairRequest.toFairDomain() } returns fair
		every { fairService.update(fairId, updateFairRequest.toFairDomain()) } returns Unit
		controller.updateFair(fairId, updateFairRequest)
		verify(exactly = 1) { fairService.update(fairId, updateFairRequest.toFairDomain()) }
	}

	@Test
	fun shouldCallFairServiceOnFairGetByCriteria(){
		val listOfFairs = getListOfFairs(fair)
		every { fairService.getFairByCriteria(getFairCriteria) } returns listOfFairs
		controller.getFairsByCriteria(getFairFilter)
		verify(exactly = 1) { fairService.getFairByCriteria(getFairCriteria) }
	}

	@Test
	fun shouldReturnListOfFairsOnResponseOfFairGetByCriteria(){
		val listOfFairs = getListOfFairs(fair)
		every { fairService.getFairByCriteria(getFairCriteria) } returns listOfFairs
		assertThat(
			controller.getFairsByCriteria(getFairFilter))
			.isInstanceOf(List::class.java)
			.first()
			.isInstanceOf(GetFairsResponse::class.java)
	}

	private fun getListOfFairs(fair: Fair): List<Fair> {
		val listOfFairs = ArrayList<Fair>()
		listOfFairs.add(fair)
		return listOfFairs
	}
}
