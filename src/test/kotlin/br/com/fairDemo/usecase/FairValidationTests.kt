package br.com.fairDemo.usecase

import br.com.fairDemo.fixtures.FairDAOFixture
import br.com.fairDemo.infrastructure.database.FairDatabaseGateway
import br.com.fairDemo.useCases.utils.FairValidation
import br.com.fairDemo.useCases.utils.FairValidationImpl
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class FairValidationTests {

    private val fairDatabaseGateway: FairDatabaseGateway = mockk()
    val validation: FairValidation = FairValidationImpl(fairDatabaseGateway)

    private val id = 1L

    @Test
    fun shouldReturnTrueWhenIdExistsOnDatabase(){
        every { fairDatabaseGateway.findById(id) } returns Optional.of(FairDAOFixture.getFairDAODomainForTests())
        assertThat(
            validation.isValid(id))
            .isEqualTo(true)
    }

    @Test
    fun shouldReturnFalseWhenIdExistsOnDatabase(){
        every { fairDatabaseGateway.findById(id) } returns Optional.empty()
        assertThat(
            validation.isValid(id))
            .isEqualTo(false)
    }
}