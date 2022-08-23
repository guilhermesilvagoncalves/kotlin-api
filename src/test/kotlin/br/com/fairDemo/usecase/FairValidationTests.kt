package br.com.fairDemo.usecase

import br.com.fairDemo.fixtures.FairFixture
import br.com.fairDemo.infrastructure.database.FairRepository
import br.com.fairDemo.useCases.utils.FairValidation
import br.com.fairDemo.useCases.utils.FairValidationImpl
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class FairValidationTests {

    private val fairRepository: FairRepository = mockk()
    val validation: FairValidation = FairValidationImpl(fairRepository)

    private val id = 1L

    @Test
    fun shouldReturnTrueWhenIdExistsOnDatabase(){
        every { fairRepository.findBy(id) } returns FairFixture.getFairDomainForTests()
        assertThat(
            validation.isValid(id))
            .isEqualTo(true)
    }

    @Test
    fun shouldReturnFalseWhenIdExistsOnDatabase(){
        every { fairRepository.findBy(id) } returns null
        assertThat(
            validation.isValid(id))
            .isEqualTo(false)
    }
}