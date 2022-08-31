package br.com.fairDemo.usecase

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.fixtures.FairFixture
import br.com.fairDemo.fixtures.GetFairFilterFixture
import br.com.fairDemo.infrastructure.database.FairDAO
import br.com.fairDemo.infrastructure.database.FairDAO.Companion.fromFairDomain
import br.com.fairDemo.infrastructure.database.FairRepository
import br.com.fairDemo.useCases.FairCRUDServiceImpl
import br.com.fairDemo.useCases.errors.FairNotFound
import br.com.fairDemo.useCases.utils.FairValidation
import br.com.fairDemo.useCases.utils.GetFairCriteria
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FairCRUDServiceTests {
    private val fairRepositoryMock : FairRepository = mockk()
    private val fairValidationMock : FairValidation = mockk()
    val service = FairCRUDServiceImpl(fairRepositoryMock, fairValidationMock)

    private val fair: Fair = FairFixture.getFairDomainForTests()
    private val fairDAO: FairDAO = fromFairDomain(fair)
    private val getFairCriteria: GetFairCriteria = GetFairFilterFixture.getGetFairFilterForTest().toFairCriteria()

    @BeforeEach
    fun setup(){
        every { fairRepositoryMock.save(any()) } returns fairDAO
    }

    @Test
    fun shouldCallFairRepositoryOnFairCreation(){
        service.create(fair)
        verify(exactly = 1) { fairRepositoryMock.save(any()) }
    }

    @Test
    fun shouldReturnFairObjectOnResponseOfFairCreation(){
        assertThat(
            service.create(fair))
            .isInstanceOf(Fair::class.java)
    }

    @Test
    fun shouldCallFairRepositoryOnFairDeletion(){
        every { fairValidationMock.isValid(fair.id!!) } returns true
        every { fairRepositoryMock.deleteById(fair.id!!) } returns Unit
        service.delete(fair.id!!)
        verify(exactly = 1) { fairRepositoryMock.deleteById(fair.id!!) }
    }

    @Test
    fun shouldReturnTrueOnResponseOfFairDeletion(){
        every { fairValidationMock.isValid(fair.id!!) } returns true
        every { fairRepositoryMock.deleteById(fair.id!!) } returns Unit
        assertThat(
            service.delete(fair.id!!))
            .isInstanceOf(Unit::class.java)
    }

    @Test
    fun shouldCallFairRepositoryOnFairUpdate(){
        val fair = FairFixture.getFairDomainForTests()
        every { fairRepositoryMock.findById(fair.id!!) } returns Optional.of(fairDAO)
        service.update(fair.id!!, fair)
        verify(atLeast = 1) { fairRepositoryMock.save(any()) }
    }

    @Test
    fun shouldReturnFairObjectOnResponseOfFairUpdate(){
        val fair = FairFixture.getFairDomainForTests()
        every { fairRepositoryMock.findById(fair.id!!) } returns Optional.of(fairDAO)
        assertThat(
            service.update(fair.id!!, fair))
            .isInstanceOf(Unit::class.java)
    }

//    @Test
//    fun shouldReturnFairNotFoundWhenFairDoesNotExistOnUpdate(){
//        val fair = FairFixture.getFairDomainForTests()
//        every { fairRepositoryMock.findById(fair.id!!) } returns Optional.empty()
//        assertThrows.assertThrows(
//            FairNotFound.class, ()-> service.update(fair.id!!, fair))
//    }

    @Test
    fun shouldReturnFairListObjectOnResponseOfGetByCriteria(){
        val list =  ArrayList<FairDAO>()
        list.add(fromFairDomain(fair))
        val otherFair = fromFairDomain(fair.copy(district = "Other district"))
        list.add(otherFair)
        every { fairRepositoryMock.findAll() } returns list
        assertThat(
            service.getFairByCriteria(getFairCriteria) ==
            list)
    }

    @Test
    fun shouldReturnFairObjectOnResponseOfGetByCriteriaByDistrict(){
        val list =  ArrayList<FairDAO>()
        val fair = FairFixture.getFairDomainForTests()
        list.add(fromFairDomain(fair))
        val otherFair = fromFairDomain(fair.copy(district = "Other district"))
        list.add(otherFair)
        val criteriaByDistrict = getFairCriteria.copy(district = "Other district")
        every { fairRepositoryMock.findAll() } returns list
        assertThat(
            service.getFairByCriteria(
                criteriaByDistrict) ==
                    list)
    }

    @Test
    fun shouldReturnFairObjectOnResponseOfGetByCriteriaByRegion5(){
        val list =  ArrayList<FairDAO>()
        val fair = FairFixture.getFairDomainForTests()
        list.add(fromFairDomain(fair))
        val otherFair = fromFairDomain(fair.copy(region5 = "Leste"))
        list.add(otherFair)
        val criteriaByDistrict = getFairCriteria.copy(region5 = "Leste")
        every { fairRepositoryMock.findAll() } returns list
        assertThat(
            service.getFairByCriteria(
                criteriaByDistrict) ==
                    list)
    }

    @Test
    fun shouldReturnFairObjectOnResponseOfGetByCriteriaByFairName(){
        val list =  ArrayList<FairDAO>()
        val fair = FairFixture.getFairDomainForTests()
        list.add(fromFairDomain(fair))
        val otherFair = fromFairDomain(fair.copy(fairName = "PRAÇA LEÃO X"))
        list.add(otherFair)
        val criteriaByDistrict = getFairCriteria.copy(fairName = "PRAÇA LEÃO X")
        every { fairRepositoryMock.findAll() } returns list
        assertThat(
            service.getFairByCriteria(
                criteriaByDistrict) ==
                    list)
    }

    @Test
    fun shouldReturnFairObjectOnResponseOfGetByCriteriaByNeighborhood(){
        val list =  ArrayList<FairDAO>()
        val fair = FairFixture.getFairDomainForTests()
        list.add(fromFairDomain(fair))
        val otherFair = fromFairDomain(fair.copy(neighborhood = "VILA FORMOSA"))
        list.add(otherFair)
        val criteriaByDistrict = getFairCriteria.copy(neighborhood = "VILA FORMOSA")
        every { fairRepositoryMock.findAll() } returns list
        assertThat(
            service.getFairByCriteria(
                criteriaByDistrict) ==
                    list)
    }

    @Test
    fun shouldReturnFairObjectOnResponseOfGetByCriteriaWhenParamAreNnull(){
        val list =  ArrayList<FairDAO>()
        val fair = FairFixture.getFairDomainForTests()
        list.add(fromFairDomain(fair))
        val criteriaByDistrict = GetFairCriteria(null, null,null,null)
        every { fairRepositoryMock.findAll() } returns list
        assertThat(
            service.getFairByCriteria(
                criteriaByDistrict) ==
                    list)
    }

}