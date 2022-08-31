package br.com.fairDemo.infrastructure.http.controller.createFair

import br.com.fairDemo.fixtures.FairFixture
import br.com.fairDemo.infrastructure.http.controller.createFair.CreateFairResponse.Companion.fromFairDomain
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle


@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class CreateFairResponseTests {

    var createFairResponse: CreateFairResponse = CreateFairResponse(
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
    fun shouldBuildCreateFairResponseWithoutDefaultParameters(){
        val createFairResponseWithoutDefaultParameters = CreateFairResponse(
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
            createFairResponseWithoutDefaultParameters)
            .isInstanceOf(CreateFairResponse::class.java)
    }


    @Test
    fun shouldBuildCreateFairResponse(){
        assertThat(
            createFairResponse)
            .isInstanceOf(CreateFairResponse::class.java)
    }

    @Test
    fun shouldReturnInstanceOfFairResponse(){
        assertThat(
            fromFairDomain(FairFixture.getFairDomainForTests()))
            .isInstanceOf(CreateFairResponse::class.java)
    }

    @Test
    fun shouldReturnLongitudeFromCreateFairResponseObject(){
        assertThat(
            createFairResponse.longitude)
            .isEqualTo(FairFixture.getFairDomainForTests().longitude)
    }

    @Test
    fun shouldReturnLatitudeFromCreateFairResponseObject(){
        assertThat(
            createFairResponse.latitude)
            .isEqualTo(FairFixture.getFairDomainForTests().latitude)
    }

    @Test
    fun shouldReturnSetcensFromCreateFairResponseObject(){
        assertThat(
            createFairResponse.setcens)
            .isEqualTo(FairFixture.getFairDomainForTests().setcens)
    }

    @Test
    fun shouldReturnAreapFromCreateFairResponseObject(){
        assertThat(
            createFairResponse.areap)
            .isEqualTo(FairFixture.getFairDomainForTests().areap)
    }

    @Test
    fun shouldReturnDistrictCodeFromCreateFairResponseObject(){
        assertThat(
            createFairResponse.districtCode)
            .isEqualTo(FairFixture.getFairDomainForTests().districtCode)
    }

    @Test
    fun shouldReturnSubPrefectureCodeFromCreateFairResponseObject(){
        assertThat(
            createFairResponse.subPrefectureCode)
            .isEqualTo(FairFixture.getFairDomainForTests().subPrefectureCode)
    }

    @Test
    fun shouldReturnSubPrefectureNameFromCreateFairResponseObject(){
        assertThat(
            createFairResponse.subPrefectureName)
            .isEqualTo(FairFixture.getFairDomainForTests().subPrefectureName)
    }

    @Test
    fun shouldReturnRegion5FromCreateFairResponseObject(){
        assertThat(
            createFairResponse.region5)
            .isEqualTo(FairFixture.getFairDomainForTests().region5)
    }

    @Test
    fun shouldReturnFairNameFromCreateFairResponseObject(){
        assertThat(
            createFairResponse.fairName)
            .isEqualTo(FairFixture.getFairDomainForTests().fairName)
    }

    @Test
    fun shouldReturnRegisterFromCreateFairResponseObject(){
        assertThat(
            createFairResponse.register)
            .isEqualTo(FairFixture.getFairDomainForTests().register)
    }

    @Test
    fun shouldReturnRegion8FromCreateFairResponseObject(){
        assertThat(
            createFairResponse.region8)
            .isEqualTo(FairFixture.getFairDomainForTests().region8)
    }

    @Test
    fun shouldReturnNeighborhoodFromCreateFairResponseObject(){
        assertThat(
            createFairResponse.neighborhood)
            .isEqualTo(FairFixture.getFairDomainForTests().neighborhood)
    }

    @Test
    fun shouldReturnNumberFromCreateFairResponseObject(){
        assertThat(
            createFairResponse.number)
            .isEqualTo(FairFixture.getFairDomainForTests().number)
    }

    @Test
    fun shouldReturnReferenceFromCreateFairResponseObject(){
        assertThat(
            createFairResponse.reference)
            .isEqualTo(FairFixture.getFairDomainForTests().reference)
    }

    @Test
    fun shouldReturnPublicPlaceFromCreateFairResponseObject(){
        assertThat(
            createFairResponse.publicPlace)
            .isEqualTo(FairFixture.getFairDomainForTests().publicPlace)
    }

    @Test
    fun shouldReturnDistrictFromCreateFairResponseObject(){
        assertThat(
            createFairResponse.district)
            .isEqualTo(FairFixture.getFairDomainForTests().district)
    }
}