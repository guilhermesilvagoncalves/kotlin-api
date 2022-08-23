package br.com.fairDemo.usecase

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.infrastructure.database.FairRepository
import br.com.fairDemo.useCases.FairCRUDServiceImpl
import br.com.fairDemo.useCases.utils.FairValidation
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FairCRUDServiceTests {
    private val fairRepositoryMock : FairRepository = mockk()
    private val fairValidationMock : FairValidation = mockk()
    val service = FairCRUDServiceImpl(fairRepositoryMock, fairValidationMock)

    private val fairMock: Fair = mockk()

    @BeforeAll
    fun setup(){
        every { fairRepositoryMock.save(fairMock) } returns fairMock
    }

    @Test
    fun shouldCallFairRepositoryOnFairCreation(){
        service.create(fairMock)
        verify(exactly = 1) { fairRepositoryMock.save(fairMock) }
    }

    @Test
    fun shouldFairObjectOnResponseOfFairCreation(){
        assertThat(
            service.create(fairMock))
            .isInstanceOf(Fair::class.java)
    }
}