package br.com.fairDemo.infrastructure.http.controller

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.fixtures.FairFixture
import br.com.fairDemo.infrastructure.http.controller.createFair.CreateFairRequest
import br.com.fairDemo.infrastructure.http.controller.createFair.CreateFairResponse
import br.com.fairDemo.infrastructure.http.controller.getFair.GetFairFilter
import br.com.fairDemo.infrastructure.http.controller.updateFair.UpdateFairRequest
import br.com.fairDemo.infrastructure.http.controller.updateFair.UpdateFairResponse
import br.com.fairDemo.useCases.FairCRUDService
import br.com.fairDemo.useCases.ImportFileFromURL
import br.com.fairDemo.useCases.utils.GetFairCriteria
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class FairControllerTests {

	private val importFileFromURL: ImportFileFromURL = mockk()
	private val fairService: FairCRUDService = mockk()
	val controller = FairController(importFileFromURL, fairService)

	private val getFairFilter: GetFairFilter = mockk()
	private val getFairCriteria: GetFairCriteria = mockk()
	private val fair: Fair = mockk()
	private val listOfFairs: List<Fair> = mockk()


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
		val fairId = FairFixture.getFairDomainForTests().id!!
		every { fairService.delete(fairId) } returns true
		controller.deleteFair(fairId)
		verify(exactly = 1) { fairService.delete(fairId) }
	}

	@Test
	fun shouldReturnNoContentOnResponseOfFairDeletionCreation(){
		val fairId = FairFixture.getFairDomainForTests().id!!
		every { fairService.delete(fairId) } returns true
		assertThat(
			controller.deleteFair(fairId))
			.isInstanceOf(Unit::class.java)
	}

	@Test
	fun shouldReturnFairObjectOnResponseOfFairUpdate(){
		val updateFairRequest: UpdateFairRequest = mockk()
		val fairId: Long = FairFixture.getFairDomainForTests().id!!
		val fair = FairFixture.getFairDomainForTests()
		every { updateFairRequest.toFairDomain() } returns fair
		every { fairService.update(fairId, updateFairRequest.toFairDomain()) } returns FairFixture.getFairDomainForTests()
		assertThat(
			controller.updateFair(fairId, updateFairRequest))
			.isInstanceOf(UpdateFairResponse::class.java)
	}

	@Test
	fun shouldCallFairServiceOnFairUpdate(){
		val updateFairRequest: UpdateFairRequest = mockk()
		val fairId: Long = FairFixture.getFairDomainForTests().id!!
		val fair = FairFixture.getFairDomainForTests()
		every { updateFairRequest.toFairDomain() } returns fair
		every { fairService.update(fairId, updateFairRequest.toFairDomain()) } returns FairFixture.getFairDomainForTests()
		controller.updateFair(fairId, updateFairRequest)
		verify(exactly = 1) { fairService.update(fairId, updateFairRequest.toFairDomain()) }
	}

	/* TODO: fix it

	@Test
	fun shouldCallFairServiceOnFairGetByCriteria(){
		every { getFairFilter.toFairCriteria() } returns getFairCriteria
		every { fairService.getFairByCriteria(getFairCriteria) } returns listOfFairs
		controller.getFair(getFairFilter)
		verify(exactly = 1) { fairService.getFairByCriteria(getFairCriteria) }
	}

	@Test
	fun shouldReturnListOfFairsOnResponseOfFairGetByCriteria(){
		every { getFairFilter.toFairCriteria() } returns getFairCriteria
		every { listOfFairs.iterator() } returns fair
		every { fairService.getFairByCriteria(getFairCriteria) } returns listOfFairs
		assertThat(
			controller.getFair(getFairFilter))
			.isInstanceOf(Unit::class.java)
	}
 */
}
