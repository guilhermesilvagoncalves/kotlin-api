package br.com.fairDemo.infrastructure.http.controller

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.fixtures.FairFixture
import br.com.fairDemo.fixtures.GetFairFilterFixture
import br.com.fairDemo.infrastructure.http.controller.createFair.CreateFairRequest
import br.com.fairDemo.infrastructure.http.controller.getFair.GetFairFilter
import br.com.fairDemo.infrastructure.http.controller.updateFair.UpdateFairRequest
import br.com.fairDemo.useCases.FairCRUDService
import br.com.fairDemo.useCases.errors.FairNotFound
import br.com.fairDemo.useCases.utils.GetFairCriteria
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.util.*

@SpringBootTest
class FairControllerTests {

	private val fairService: FairCRUDService = mockk()
	val controller = FairController(fairService)

	private val getFairFilter: GetFairFilter = GetFairFilterFixture.getGetFairFilterForTest()

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
	fun shouldReturnErrorWhenFairIdDoesNotExistOnDelete(){
		val fairId: Long = FairFixture.getFairDomainForTests().id!!
		every { fairService.delete(fairId) } throws FairNotFound("Fair not found")
		assertThat(
			controller.deleteFair(fairId) == getFairNotFoundErrorResponseEntity())
		}

	@Test
	fun shouldReturnErrorWhenIsNotFairIdDoesNotExistOnDelete(){
		val fairId: Long = FairFixture.getFairDomainForTests().id!!
		every { fairService.delete(fairId) } throws Exception("Internal Error")
		assertThat(
			controller.deleteFair(fairId) == getInternalServerErrorResponseEntity())
	}

	@Test
	fun shouldReturnErrorWhenFairIdDoesNotExistOnUpdate(){
		val updateFairRequest: UpdateFairRequest = mockk()
		every { updateFairRequest.toFairDomain() } returns FairFixture.getFairDomainForTests()
		val fairId = FairFixture.getFairDomainForTests().id!!
		every { fairService.update(fairId, updateFairRequest.toFairDomain()) } throws FairNotFound("Fair not found")
		assertThat(
			controller.updateFair(fairId, updateFairRequest) == getFairNotFoundErrorResponseEntity())
	}

	@Test
	fun shouldReturnErrorWhenIsNotFairIdDoesNotExistOnUpdate(){
		val updateFairRequest: UpdateFairRequest = mockk()
		every { updateFairRequest.toFairDomain() } returns FairFixture.getFairDomainForTests()
		val fairId = FairFixture.getFairDomainForTests().id!!
		every { fairService.delete(fairId) } throws Exception("Internal Error")
		assertThat(
			controller.updateFair(fairId, updateFairRequest) == getFairNotFoundErrorResponseEntity())
	}

	private fun getFairNotFoundErrorResponseEntity(): ResponseEntity<String> {
		return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body("Fair not found")
	}

	private fun getInternalServerErrorResponseEntity(): ResponseEntity<String> {
		return ResponseEntity
			.status(HttpStatus.BAD_REQUEST)
			.body("Internal Error")
	}

	@Test
	fun shouldReturnListOfFairsOnGetRequestWithoutParameters(){
		val listOfFairs = ArrayList<Fair>()
		val fair = FairFixture.getFairDomainForTests()
		listOfFairs.add(fair)
		val district = null
		val region5 = null
		val fairName = null
		val neighborhood = null
		val criteria = GetFairCriteria(district, region5, fairName, neighborhood)
		every { fairService.getFairByCriteria(criteria) } returns listOfFairs
		assertThat(
			controller.getFairsByCriteria(district, region5, fairName, neighborhood) ==
					listOfFairs)
	}

	@Test
	fun shouldReturnListOfFairsOnGetRequestWithDistrict(){
		val listOfFairs = ArrayList<Fair>()
		val fair = FairFixture.getFairDomainForTests()
		fair.district = "District"
		listOfFairs.add(fair)
		val district = "District"
		val region5 = null
		val fairName = null
		val neighborhood = null
		val criteria = GetFairCriteria(district, region5, fairName, neighborhood)
		every { fairService.getFairByCriteria(criteria) } returns listOfFairs
		assertThat(
			controller.getFairsByCriteria(district, region5, fairName, neighborhood) ==
					listOfFairs)
	}

	@Test
	fun shouldReturnListOfFairsOnGetRequestWithRegion5(){
		val listOfFairs = ArrayList<Fair>()
		val fair = FairFixture.getFairDomainForTests()
		fair.region5 = "Regiao 5"
		listOfFairs.add(fair)
		val district = null
		val region5 = "Regiao 5"
		val fairName = null
		val neighborhood = null
		val criteria = GetFairCriteria(district, region5, fairName, neighborhood)
		every { fairService.getFairByCriteria(criteria) } returns listOfFairs
		assertThat(
			controller.getFairsByCriteria(district, region5, fairName, neighborhood) ==
					listOfFairs)
	}

	@Test
	fun shouldReturnListOfFairsOnGetRequestWithFairName(){
		val listOfFairs = ArrayList<Fair>()
		val fair = FairFixture.getFairDomainForTests()
		fair.fairName = "Fair Name"
		listOfFairs.add(fair)
		val district = null
		val region5 = null
		val fairName = "Fair Name"
		val neighborhood = null
		val criteria = GetFairCriteria(district, region5, fairName, neighborhood)
		every { fairService.getFairByCriteria(criteria) } returns listOfFairs
		assertThat(
			controller.getFairsByCriteria(district, region5, fairName, neighborhood) ==
					listOfFairs)
	}


	@Test
	fun shouldReturnListOfFairsOnGetRequestWithNeighborhood(){
		val listOfFairs = ArrayList<Fair>()
		val fair = FairFixture.getFairDomainForTests()
		fair.neighborhood = "Neighborhood"
		listOfFairs.add(fair)
		val district = null
		val region5 = null
		val fairName = null
		val neighborhood = "Neighborhood"
		val criteria = GetFairCriteria(district, region5, fairName, neighborhood)
		every { fairService.getFairByCriteria(criteria) } returns listOfFairs
		assertThat(
			controller.getFairsByCriteria(district, region5, fairName, neighborhood) ==
					listOfFairs)
	}
}
