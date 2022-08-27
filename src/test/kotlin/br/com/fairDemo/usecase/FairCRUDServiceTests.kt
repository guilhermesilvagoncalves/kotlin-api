package br.com.fairDemo.usecase

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.fixtures.FairFixture
import br.com.fairDemo.fixtures.GetFairFilterFixture
import br.com.fairDemo.infrastructure.database.FairDAO
import br.com.fairDemo.infrastructure.database.FairDAO.Companion.fromFairDomain
import br.com.fairDemo.infrastructure.database.FairRepository
import br.com.fairDemo.useCases.FairCRUDServiceImpl
import br.com.fairDemo.useCases.utils.FairValidation
import br.com.fairDemo.useCases.utils.GetFairCriteria
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
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
    private val getFairCriteriaMock: GetFairCriteria = GetFairFilterFixture.getGetFairFilterForTest().toFairCriteria()

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
        every { fairValidationMock.isValid(fairDAO.id!!) } returns true
        every { fairRepositoryMock.deleteById(fairDAO.id!!) } returns Unit
        service.delete(fairDAO.id!!)
        verify(exactly = 1) { fairRepositoryMock.deleteById(fairDAO.id!!) }
    }

    @Test
    fun shouldReturnTrueOnResponseOfFairDeletion(){
        every { fairValidationMock.isValid(fairDAO.id!!) } returns true
        every { fairRepositoryMock.deleteById(fairDAO.id!!) } returns Unit
        assertThat(
            service.delete(fairDAO.id!!))
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

    @Test
    fun shouldReturnFairObjectOnResponseOfGetByCriteria(){
        assertThat(
            service.getFairByCriteria(getFairCriteriaMock))
            .isInstanceOf(List::class.java)
    }
}