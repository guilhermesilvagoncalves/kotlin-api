package br.com.fairDemo.usecase

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.fixtures.FairFixture
import br.com.fairDemo.infrastructure.database.FairRepository
import br.com.fairDemo.infrastructure.http.controller.getFair.GetFairFilter
import br.com.fairDemo.useCases.FairCRUDServiceImpl
import br.com.fairDemo.useCases.utils.FairValidation
import br.com.fairDemo.useCases.utils.GetFairCriteria
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.context.properties.bind.Bindable.listOf
import org.springframework.boot.test.context.SpringBootTest
import java.util.*
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FairCRUDServiceTests {
    private val fairRepositoryMock : FairRepository = mockk()
    private val fairValidationMock : FairValidation = mockk()
    val service = FairCRUDServiceImpl(fairRepositoryMock, fairValidationMock)

    private val fairMock: Fair = mockk()
    private val getFairCriteriaMock: GetFairCriteria = mockk()
    private val listOfFairs: List<Fair> = mockk()

    @BeforeEach
    fun setup(){
        every { fairMock.id } returns FairFixture.getFairDomainForTests().id
        every { fairRepositoryMock.save(fairMock) } returns fairMock
        every { fairRepositoryMock.findBy(getFairCriteriaMock) } returns listOfFairs

        /*
        every { fairValidationMock.isValid(fairMock.id) } returns true
        every { fairRepositoryMock.delete(fairMock.id) } returns Unit
        every { fairRepositoryMock.findBy(fairMock.id) } returns fairMock

         */
    }

    @Test
    fun shouldCallFairRepositoryOnFairCreation(){
        service.create(fairMock)
        verify(exactly = 1) { fairRepositoryMock.save(fairMock) }
    }

    @Test
    fun shouldReturnFairObjectOnResponseOfFairCreation(){
        assertThat(
            service.create(fairMock))
            .isInstanceOf(Fair::class.java)
    }

    //TODO: Fix those tests
/*
    @Test
    fun shouldCallFairRepositoryOnFairDeletion(){
        service.delete(fairMock.id)
        verify(exactly = 1) { fairRepositoryMock.delete(fairMock.id) }
    }

    @Test
    fun shouldReturnTrueOnResponseOfFairDeletion(){
        assertThat(
            service.delete(fairMock.id))
            .isTrue
    }

    @Test
    fun shouldCallFairRepositoryOnFairUpdate(){
        service.update(FairFixture.getFairDomainForTests())
        verify(exactly = 1) { fairRepositoryMock.save(any()) }
    }

    @Test
    fun shouldReturnFairObjectOnResponseOfFairUpdate(){
        assertThat(
            service.update(FairFixture.getFairDomainForTests()))
            .isInstanceOf(Fair::class.java)
    }
 */

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