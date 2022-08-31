package br.com.fairDemo.infrastructure.http.controller.updateFair

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.fixtures.FairFixture
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle


@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class UpdateFairRequestTests {

    var updateFairRequest: UpdateFairRequest = UpdateFairRequest(
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
    fun shouldBuildUpdateFairRequestWithoutDefaultParameters(){
        val updateFairRequestWithoutDefaultParameters = UpdateFairRequest(
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
            updateFairRequestWithoutDefaultParameters)
            .isInstanceOf(UpdateFairRequest::class.java)
    }


    @Test
    fun shouldBuildUpdateFairRequest(){
        assertThat(
            updateFairRequest)
            .isInstanceOf(UpdateFairRequest::class.java)
    }

    @Test
    fun shouldReturnInstanceOfFairDomain(){
        assertThat(
            updateFairRequest.toFairDomain())
            .isInstanceOf(Fair::class.java)
    }

    @Test
    fun shouldReturnLongitudeFromUpdateFairRequestObject(){
        assertThat(
            updateFairRequest.longitude)
            .isEqualTo(FairFixture.getFairDomainForTests().longitude)
    }

    @Test
    fun shouldReturnLatitudeFromUpdateFairRequestObject(){
        assertThat(
            updateFairRequest.latitude)
            .isEqualTo(FairFixture.getFairDomainForTests().latitude)
    }

    @Test
    fun shouldReturnSetcensFromUpdateFairRequestObject(){
        assertThat(
            updateFairRequest.setcens)
            .isEqualTo(FairFixture.getFairDomainForTests().setcens)
    }

    @Test
    fun shouldReturnAreapFromUpdateFairRequestObject(){
        assertThat(
            updateFairRequest.areap)
            .isEqualTo(FairFixture.getFairDomainForTests().areap)
    }

    @Test
    fun shouldReturnDistrictCodeFromUpdateFairRequestObject(){
        assertThat(
            updateFairRequest.districtCode)
            .isEqualTo(FairFixture.getFairDomainForTests().districtCode)
    }

    @Test
    fun shouldReturnSubPrefectureCodeFromUpdateFairRequestObject(){
        assertThat(
            updateFairRequest.subPrefectureCode)
            .isEqualTo(FairFixture.getFairDomainForTests().subPrefectureCode)
    }

    @Test
    fun shouldReturnSubPrefectureNameFromUpdateFairRequestObject(){
        assertThat(
            updateFairRequest.subPrefectureName)
            .isEqualTo(FairFixture.getFairDomainForTests().subPrefectureName)
    }

    @Test
    fun shouldReturnRegion5FromUpdateFairRequestObject(){
        assertThat(
            updateFairRequest.region5)
            .isEqualTo(FairFixture.getFairDomainForTests().region5)
    }

    @Test
    fun shouldReturnFairNameFromUpdateFairRequestObject(){
        assertThat(
            updateFairRequest.fairName)
            .isEqualTo(FairFixture.getFairDomainForTests().fairName)
    }

    @Test
    fun shouldReturnRegisterFromUpdateFairRequestObject(){
        assertThat(
            updateFairRequest.register)
            .isEqualTo(FairFixture.getFairDomainForTests().register)
    }

    @Test
    fun shouldReturnRegion8FromUpdateFairRequestObject(){
        assertThat(
            updateFairRequest.region8)
            .isEqualTo(FairFixture.getFairDomainForTests().region8)
    }

    @Test
    fun shouldReturnNeighborhoodFromUpdateFairRequestObject(){
        assertThat(
            updateFairRequest.neighborhood)
            .isEqualTo(FairFixture.getFairDomainForTests().neighborhood)
    }

    @Test
    fun shouldReturnNumberFromUpdateFairRequestObject(){
        assertThat(
            updateFairRequest.number)
            .isEqualTo(FairFixture.getFairDomainForTests().number)
    }

    @Test
    fun shouldReturnReferenceFromUpdateFairRequestObject(){
        assertThat(
            updateFairRequest.reference)
            .isEqualTo(FairFixture.getFairDomainForTests().reference)
    }

    @Test
    fun shouldReturnPublicPlaceFromUpdateFairRequestObject(){
        assertThat(
            updateFairRequest.publicPlace)
            .isEqualTo(FairFixture.getFairDomainForTests().publicPlace)
    }

    @Test
    fun shouldReturnDistrictFromUpdateFairRequestObject(){
        assertThat(
            updateFairRequest.district)
            .isEqualTo(FairFixture.getFairDomainForTests().district)
    }
}