package br.com.fairDemo.infrastructure.http.controller.getFair

import br.com.fairDemo.fixtures.FairFixture
import br.com.fairDemo.infrastructure.http.controller.getFair.GetFairsResponse.Companion.fromFairDomain
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle


@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class GetFairsResponseTests {

    var getFairsResponse: GetFairsResponse = GetFairsResponse(
        id = FairFixture.getFairDomainForTests().id,
        longitude = FairFixture.getFairDomainForTests().longitude,
        latitude = FairFixture.getFairDomainForTests().latitude,
        setcens = FairFixture.getFairDomainForTests().setcens,
        areap = FairFixture.getFairDomainForTests().areap,
        districtCode = FairFixture.getFairDomainForTests().districtCode,
        district = FairFixture.getFairDomainForTests().district,
        subPrefectureCode = FairFixture.getFairDomainForTests().subPrefectureCode,
        subPrefectureName = FairFixture.getFairDomainForTests().subPrefectureName,
        region5 = FairFixture.getFairDomainForTests().region5,
        region8 = FairFixture.getFairDomainForTests().region8,
        fairName = FairFixture.getFairDomainForTests().fairName,
        register = FairFixture.getFairDomainForTests().register,
        publicPlace = FairFixture.getFairDomainForTests().publicPlace,
        number = FairFixture.getFairDomainForTests().number,
        neighborhood = FairFixture.getFairDomainForTests().neighborhood,
        reference = FairFixture.getFairDomainForTests().reference
    )

    @Test
    fun shouldBuildGetFairsResponseTestsWithoutDefaultParameters(){
        val getFairsResponseTestsWithoutDefaultParameters = GetFairsResponse(
            id = FairFixture.getFairDomainForTests().id,
            longitude = FairFixture.getFairDomainForTests().longitude,
            latitude = FairFixture.getFairDomainForTests().latitude,
            setcens = FairFixture.getFairDomainForTests().setcens,
            areap = FairFixture.getFairDomainForTests().areap,
            districtCode = FairFixture.getFairDomainForTests().districtCode,
            district = FairFixture.getFairDomainForTests().district,
            subPrefectureCode = FairFixture.getFairDomainForTests().subPrefectureCode,
            subPrefectureName = FairFixture.getFairDomainForTests().subPrefectureName,
            region5 = FairFixture.getFairDomainForTests().region5,
            region8 = FairFixture.getFairDomainForTests().region8,
            fairName = FairFixture.getFairDomainForTests().fairName,
            register = FairFixture.getFairDomainForTests().register,
            publicPlace = FairFixture.getFairDomainForTests().publicPlace
        )
        assertThat(
            getFairsResponseTestsWithoutDefaultParameters)
            .isInstanceOf(GetFairsResponse::class.java)
    }


    @Test
    fun shouldBuildGetFairsResponseTests(){
        assertThat(
            getFairsResponse)
            .isInstanceOf(GetFairsResponse::class.java)
    }

    @Test
    fun shouldReturnInstanceOfGetFairsResponse(){
        assertThat(
            fromFairDomain(FairFixture.getFairDomainForTests()))
            .isInstanceOf(GetFairsResponse::class.java)
    }

    @Test
    fun shouldReturnIdFromGetFairsResponseRequestObject(){
        assertThat(
            getFairsResponse.id)
            .isEqualTo(FairFixture.getFairDomainForTests().id)
    }

    @Test
    fun shouldReturnLongitudeFromGetFairsResponseRequestObject(){
        assertThat(
            getFairsResponse.longitude)
            .isEqualTo(FairFixture.getFairDomainForTests().longitude)
    }

    @Test
    fun shouldReturnLatitudeFromGetFairsResponseRequestObject(){
        assertThat(
            getFairsResponse.latitude)
            .isEqualTo(FairFixture.getFairDomainForTests().latitude)
    }

    @Test
    fun shouldReturnSetcensFromGetFairsResponseRequestObject(){
        assertThat(
            getFairsResponse.setcens)
            .isEqualTo(FairFixture.getFairDomainForTests().setcens)
    }

    @Test
    fun shouldReturnAreapFromGetFairsResponseRequestObject(){
        assertThat(
            getFairsResponse.areap)
            .isEqualTo(FairFixture.getFairDomainForTests().areap)
    }

    @Test
    fun shouldReturnDistrictCodeFromGetFairsResponseRequestObject(){
        assertThat(
            getFairsResponse.districtCode)
            .isEqualTo(FairFixture.getFairDomainForTests().districtCode)
    }

    @Test
    fun shouldReturnSubPrefectureCodeFromGetFairsResponseRequestObject(){
        assertThat(
            getFairsResponse.subPrefectureCode)
            .isEqualTo(FairFixture.getFairDomainForTests().subPrefectureCode)
    }

    @Test
    fun shouldReturnSubPrefectureNameFromGetFairsResponseRequestObject(){
        assertThat(
            getFairsResponse.subPrefectureName)
            .isEqualTo(FairFixture.getFairDomainForTests().subPrefectureName)
    }

    @Test
    fun shouldReturnRegion5FromGetFairsResponseRequestObject(){
        assertThat(
            getFairsResponse.region5)
            .isEqualTo(FairFixture.getFairDomainForTests().region5)
    }

    @Test
    fun shouldReturnFairNameFromGetFairsResponseRequestObject(){
        assertThat(
            getFairsResponse.fairName)
            .isEqualTo(FairFixture.getFairDomainForTests().fairName)
    }

    @Test
    fun shouldReturnRegisterFromGetFairsResponseRequestObject(){
        assertThat(
            getFairsResponse.register)
            .isEqualTo(FairFixture.getFairDomainForTests().register)
    }

    @Test
    fun shouldReturnRegion8FromGetFairsResponseRequestObject(){
        assertThat(
            getFairsResponse.region8)
            .isEqualTo(FairFixture.getFairDomainForTests().region8)
    }

    @Test
    fun shouldReturnNeighborhoodFromGetFairsResponseRequestObject(){
        assertThat(
            getFairsResponse.neighborhood)
            .isEqualTo(FairFixture.getFairDomainForTests().neighborhood)
    }

    @Test
    fun shouldReturnNumberFromGetFairsResponseRequestObject(){
        assertThat(
            getFairsResponse.number)
            .isEqualTo(FairFixture.getFairDomainForTests().number)
    }

    @Test
    fun shouldReturnReferenceFromGetFairsResponseRequestObject(){
        assertThat(
            getFairsResponse.reference)
            .isEqualTo(FairFixture.getFairDomainForTests().reference)
    }

    @Test
    fun shouldReturnPublicPlaceFromGetFairsResponseRequestObject(){
        assertThat(
            getFairsResponse.publicPlace)
            .isEqualTo(FairFixture.getFairDomainForTests().publicPlace)
    }

    @Test
    fun shouldReturnDistrictFromGetFairsResponseRequestObject(){
        assertThat(
            getFairsResponse.district)
            .isEqualTo(FairFixture.getFairDomainForTests().district)
    }
}