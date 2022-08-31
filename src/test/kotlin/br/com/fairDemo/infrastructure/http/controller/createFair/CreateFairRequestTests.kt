package br.com.fairDemo.infrastructure.http.controller.createFair

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.fixtures.FairFixture
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle


@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class CreateFairRequestTests {

    var createFairRequest: CreateFairRequest = CreateFairRequest(
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
    fun shouldBuildCreateFairRequestWithoutDefaultParameters(){
        val createFairRequestWithoutDefaultParameters = CreateFairRequest(
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
            createFairRequestWithoutDefaultParameters)
            .isInstanceOf(CreateFairRequest::class.java)
    }


    @Test
    fun shouldBuildCreateFairRequest(){
        assertThat(
            createFairRequest)
            .isInstanceOf(CreateFairRequest::class.java)
    }

    @Test
    fun shouldReturnInstanceOfFairDomain(){
        assertThat(
            createFairRequest.toFairDomain())
            .isInstanceOf(Fair::class.java)
    }

    @Test
    fun shouldReturnLongitudeFromCreateFairRequestObject(){
        assertThat(
            createFairRequest.longitude)
            .isEqualTo(FairFixture.getFairDomainForTests().longitude)
    }

    @Test
    fun shouldReturnLatitudeFromCreateFairRequestObject(){
        assertThat(
            createFairRequest.latitude)
            .isEqualTo(FairFixture.getFairDomainForTests().latitude)
    }

    @Test
    fun shouldReturnSetcensFromCreateFairRequestObject(){
        assertThat(
            createFairRequest.setcens)
            .isEqualTo(FairFixture.getFairDomainForTests().setcens)
    }

    @Test
    fun shouldReturnAreapFromCreateFairRequestObject(){
        assertThat(
            createFairRequest.areap)
            .isEqualTo(FairFixture.getFairDomainForTests().areap)
    }

    @Test
    fun shouldReturnDistrictCodeFromCreateFairRequestObject(){
        assertThat(
            createFairRequest.districtCode)
            .isEqualTo(FairFixture.getFairDomainForTests().districtCode)
    }

    @Test
    fun shouldReturnSubPrefectureCodeFromCreateFairRequestObject(){
        assertThat(
            createFairRequest.subPrefectureCode)
            .isEqualTo(FairFixture.getFairDomainForTests().subPrefectureCode)
    }

    @Test
    fun shouldReturnSubPrefectureNameFromCreateFairRequestObject(){
        assertThat(
            createFairRequest.subPrefectureName)
            .isEqualTo(FairFixture.getFairDomainForTests().subPrefectureName)
    }

    @Test
    fun shouldReturnRegion5FromCreateFairRequestObject(){
        assertThat(
            createFairRequest.region5)
            .isEqualTo(FairFixture.getFairDomainForTests().region5)
    }

    @Test
    fun shouldReturnFairNameFromCreateFairRequestObject(){
        assertThat(
            createFairRequest.fairName)
            .isEqualTo(FairFixture.getFairDomainForTests().fairName)
    }

    @Test
    fun shouldReturnRegisterFromCreateFairRequestObject(){
        assertThat(
            createFairRequest.register)
            .isEqualTo(FairFixture.getFairDomainForTests().register)
    }

    @Test
    fun shouldReturnRegion8FromCreateFairRequestObject(){
        assertThat(
            createFairRequest.region8)
            .isEqualTo(FairFixture.getFairDomainForTests().region8)
    }

    @Test
    fun shouldReturnNeighborhoodFromCreateFairRequestObject(){
        assertThat(
            createFairRequest.neighborhood)
            .isEqualTo(FairFixture.getFairDomainForTests().neighborhood)
    }

    @Test
    fun shouldReturnNumberFromCreateFairRequestObject(){
        assertThat(
            createFairRequest.number)
            .isEqualTo(FairFixture.getFairDomainForTests().number)
    }

    @Test
    fun shouldReturnReferenceFromCreateFairRequestObject(){
        assertThat(
            createFairRequest.reference)
            .isEqualTo(FairFixture.getFairDomainForTests().reference)
    }

    @Test
    fun shouldReturnPublicPlaceFromCreateFairRequestObject(){
        assertThat(
            createFairRequest.publicPlace)
            .isEqualTo(FairFixture.getFairDomainForTests().publicPlace)
    }

    @Test
    fun shouldReturnDistrictFromCreateFairRequestObject(){
        assertThat(
            createFairRequest.district)
            .isEqualTo(FairFixture.getFairDomainForTests().district)
    }
}