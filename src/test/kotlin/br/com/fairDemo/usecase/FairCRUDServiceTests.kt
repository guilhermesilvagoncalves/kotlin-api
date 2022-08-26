package br.com.fairDemo.usecase

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.fixtures.FairFixture
import br.com.fairDemo.fixtures.GetFairFilterFixture
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
    private val getFairCriteriaMock: GetFairCriteria = GetFairFilterFixture.getGetFairFilterForTest().toFairCriteria()
    private val listOfFairs: List<Fair> = mockk()

    @BeforeEach
    fun setup(){
        every { fairRepositoryMock.save(fair) } returns fair
        every { fairRepositoryMock.findBy(getFairCriteriaMock) } returns listOfFairs

        /*
        every { fairRepositoryMock.findBy(fairMock.id) } returns fairMock

         */
    }

    @Test
    fun shouldCallFairRepositoryOnFairCreation(){
        service.create(fair)
        verify(exactly = 1) { fairRepositoryMock.save(fair) }
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
        every { fairRepositoryMock.delete(fair.id!!) } returns Unit
        service.delete(fair.id!!)
        verify(exactly = 1) { fairRepositoryMock.delete(fair.id!!) }
    }

    @Test
    fun shouldReturnTrueOnResponseOfFairDeletion(){
        every { fairValidationMock.isValid(fair.id!!) } returns true
        every { fairRepositoryMock.delete(fair.id!!) } returns Unit
        assertThat(
            service.delete(fair.id!!))
            .isTrue
    }

    @Test
    fun shouldCallFairRepositoryOnFairUpdate(){
        val fair = FairFixture.getFairDomainForTests()
        every { fairRepositoryMock.findBy(fair.id!!) } returns fair
        service.update(fair.id!!, fair)
        verify(atLeast = 1) { fairRepositoryMock.save(any()) }
    }

    @Test
    fun shouldReturnFairObjectOnResponseOfFairUpdate(){
        val fair = FairFixture.getFairDomainForTests()
        every { fairRepositoryMock.findBy(fair.id!!) } returns fair
        assertThat(
            service.update(fair.id!!, fair))
            .isInstanceOf(Fair::class.java)
    }

    @Test
    fun shouldCallFairRepositoryOnFairGetByCriteria(){
        service.getFairByCriteria(getFairCriteriaMock)
        verify(atLeast = 1) { fairRepositoryMock.findBy(getFairCriteriaMock) }
    }

    @Test
    fun shouldReturnFairObjectOnResponseOfGetByCriteria(){
        assertThat(
            service.getFairByCriteria(getFairCriteriaMock))
            .isInstanceOf(List::class.java)
    }
}