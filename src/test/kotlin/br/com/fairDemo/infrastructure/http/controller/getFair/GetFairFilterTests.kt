package br.com.fairDemo.infrastructure.http.controller.getFair

import br.com.fairDemo.fixtures.FairFixture
import br.com.fairDemo.useCases.utils.GetFairCriteria
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle


@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class GetFairFilterTests {

    var getFairFilterTests: GetFairFilter = GetFairFilter(
        district = FairFixture.getFairDomainForTests().district,
        region5 = FairFixture.getFairDomainForTests().region5,
        fairName = FairFixture.getFairDomainForTests().fairName,
        neighborhood = FairFixture.getFairDomainForTests().neighborhood!!,
    )

    @Test
    fun shouldBuildGetFairFilterTestsWithoutDefaultParameters(){
        val getFairFilterTestsWithoutDefaultParameters = GetFairFilter()
        assertThat(
            getFairFilterTestsWithoutDefaultParameters)
            .isInstanceOf(GetFairFilter::class.java)
    }


    @Test
    fun shouldBuildGetFairFilterTests(){
        assertThat(
            getFairFilterTests)
            .isInstanceOf(GetFairFilter::class.java)
    }

    @Test
    fun shouldReturnInstanceOfFairDomain(){
        assertThat(
            getFairFilterTests.toFairCriteria())
            .isInstanceOf(GetFairCriteria::class.java)
    }

    @Test
    fun shouldReturnRegion5FromGetFairFilterTestsObject(){
        assertThat(
            getFairFilterTests.region5)
            .isEqualTo(FairFixture.getFairDomainForTests().region5)
    }

    @Test
    fun shouldReturnFairNameFromGetFairFilterTestsObject(){
        assertThat(
            getFairFilterTests.fairName)
            .isEqualTo(FairFixture.getFairDomainForTests().fairName)
    }

    @Test
    fun shouldReturnNeighborhoodFromGetFairFilterTestsObject(){
        assertThat(
            getFairFilterTests.neighborhood)
            .isEqualTo(FairFixture.getFairDomainForTests().neighborhood)
    }

    @Test
    fun shouldReturnDistrictFromGetFairFilterTestsObject(){
        assertThat(
            getFairFilterTests.district)
            .isEqualTo(FairFixture.getFairDomainForTests().district)
    }
}