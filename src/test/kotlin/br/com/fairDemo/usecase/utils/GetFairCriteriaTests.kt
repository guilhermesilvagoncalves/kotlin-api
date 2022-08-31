package br.com.fairDemo.usecase.utils

import br.com.fairDemo.fixtures.FairFixture
import br.com.fairDemo.useCases.utils.GetFairCriteria
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle


@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class GetFairCriteriaTests {

    var getFairCriteria: GetFairCriteria = GetFairCriteria(
        district = FairFixture.getFairDomainForTests().district,
        region5 = FairFixture.getFairDomainForTests().region5,
        fairName = FairFixture.getFairDomainForTests().fairName,
        neighborhood = FairFixture.getFairDomainForTests().neighborhood!!,
    )

    @Test
    fun shouldBuildGetFairCriteriaTestsWithoutDefaultParameters(){
        val getFairCriteriaTestsWithoutDefaultParameters = GetFairCriteria()
        assertThat(
            getFairCriteriaTestsWithoutDefaultParameters)
            .isInstanceOf(GetFairCriteria::class.java)
    }

    @Test
    fun shouldBuildGetFairCriteriaTests(){
        assertThat(
            getFairCriteria)
            .isInstanceOf(GetFairCriteria::class.java)
    }

    @Test
    fun shouldReturnRegion5FromGetFairCriteriaTestsObject(){
        assertThat(
            getFairCriteria.region5)
            .isEqualTo(FairFixture.getFairDomainForTests().region5)
    }

    @Test
    fun shouldReturnFairNameFromGetFairCriteriaTestsObject(){
        assertThat(
            getFairCriteria.fairName)
            .isEqualTo(FairFixture.getFairDomainForTests().fairName)
    }

    @Test
    fun shouldReturnNeighborhoodFromGetFairCriteriaTestsObject(){
        assertThat(
            getFairCriteria.neighborhood)
            .isEqualTo(FairFixture.getFairDomainForTests().neighborhood)
    }

    @Test
    fun shouldReturnDistrictFromGetFairCriteriaTestsObject(){
        assertThat(
            getFairCriteria.district)
            .isEqualTo(FairFixture.getFairDomainForTests().district)
    }
}