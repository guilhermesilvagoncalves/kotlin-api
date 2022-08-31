package br.com.fairDemo.entity

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.fixtures.FairFixture
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle
import java.math.BigDecimal
import java.math.BigInteger


@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class FairTests {

    var fair: Fair = Fair(
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
    fun shouldBuildFairWithoutDefaultParameters() {
        val fairWithoutDefaultParameters = Fair(
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
            fairWithoutDefaultParameters
        )
            .isInstanceOf(Fair::class.java)
    }


    @Test
    fun shouldBuildFair() {
        assertThat(
            fair
        )
            .isInstanceOf(Fair::class.java)
    }

    @Test
    fun shouldReturnLongitudeFromFairObject() {
        assertThat(
            fair.longitude
        )
            .isEqualTo(FairFixture.getFairDomainForTests().longitude)
    }

    @Test
    fun shouldReturnLatitudeFromFairObject() {
        assertThat(
            fair.latitude
        )
            .isEqualTo(FairFixture.getFairDomainForTests().latitude)
    }

    @Test
    fun shouldReturnSetcensFromFairObject() {
        assertThat(
            fair.setcens
        )
            .isEqualTo(FairFixture.getFairDomainForTests().setcens)
    }

    @Test
    fun shouldReturnAreapFromFairObject() {
        assertThat(
            fair.areap
        )
            .isEqualTo(FairFixture.getFairDomainForTests().areap)
    }

    @Test
    fun shouldReturnDistrictCodeFromFairObject() {
        assertThat(
            fair.districtCode
        )
            .isEqualTo(FairFixture.getFairDomainForTests().districtCode)
    }

    @Test
    fun shouldReturnSubPrefectureCodeFromFairObject() {
        assertThat(
            fair.subPrefectureCode
        )
            .isEqualTo(FairFixture.getFairDomainForTests().subPrefectureCode)
    }

    @Test
    fun shouldReturnSubPrefectureNameFromFairObject() {
        assertThat(
            fair.subPrefectureName
        )
            .isEqualTo(FairFixture.getFairDomainForTests().subPrefectureName)
    }

    @Test
    fun shouldReturnRegion5FromFairObject() {
        assertThat(
            fair.region5
        )
            .isEqualTo(FairFixture.getFairDomainForTests().region5)
    }

    @Test
    fun shouldReturnFairNameFromFairObject() {
        assertThat(
            fair.fairName
        )
            .isEqualTo(FairFixture.getFairDomainForTests().fairName)
    }

    @Test
    fun shouldReturnRegisterFromFairObject() {
        assertThat(
            fair.register
        )
            .isEqualTo(FairFixture.getFairDomainForTests().register)
    }

    @Test
    fun shouldReturnRegion8FromFairObject() {
        assertThat(
            fair.region8
        )
            .isEqualTo(FairFixture.getFairDomainForTests().region8)
    }

    @Test
    fun shouldReturnNeighborhoodFromFairObject() {
        assertThat(
            fair.neighborhood
        )
            .isEqualTo(FairFixture.getFairDomainForTests().neighborhood)
    }

    @Test
    fun shouldReturnNumberFromFairObject() {
        assertThat(
            fair.number
        )
            .isEqualTo(FairFixture.getFairDomainForTests().number)
    }

    @Test
    fun shouldReturnReferenceFromFairObject() {
        assertThat(
            fair.reference
        )
            .isEqualTo(FairFixture.getFairDomainForTests().reference)
    }

    @Test
    fun shouldReturnPublicPlaceFromFairObject() {
        assertThat(
            fair.publicPlace
        )
            .isEqualTo(FairFixture.getFairDomainForTests().publicPlace)
    }

    @Test
    fun shouldReturnDistrictFromFairObject() {
        assertThat(
            fair.district
        )
            .isEqualTo(FairFixture.getFairDomainForTests().district)
    }

    @Test
    fun shouldSetLongitudeFromFairObject() {
        val fairForTest = Fair()
        val longitudeForTest = BigInteger.valueOf(-1000)
        fairForTest.longitude = longitudeForTest
        assertThat(
            fairForTest.longitude
        )
            .isEqualTo(longitudeForTest)
    }

    @Test
    fun shouldSetLatitudeFromFairObject() {
        val fairForTest = Fair()
        val latitudeForTest = BigInteger.valueOf(-2000)
        fairForTest.latitude = latitudeForTest
        assertThat(
            fairForTest.latitude
        )
            .isEqualTo(latitudeForTest)
    }

    @Test
    fun shouldSetSetcensLatitudeFromFairObject() {
        val fairForTest = Fair()
        val setcensForTest = BigInteger.valueOf(-3000)
        fairForTest.setcens = setcensForTest
        assertThat(
            fairForTest.setcens
        )
            .isEqualTo(setcensForTest)
    }

    @Test
    fun shouldSetDistrictCodeLatitudeFromFairObject() {
        val fairForTest = Fair()
        val districtCodeForTest = -5000
        fairForTest.districtCode = districtCodeForTest
        assertThat(
            fairForTest.districtCode
        )
            .isEqualTo(districtCodeForTest)
    }

    @Test
    fun shouldSetDistrictLatitudeFromFairObject() {
        val fairForTest = Fair()
        val districtForTest = "District"
        fairForTest.district = districtForTest
        assertThat(
            fairForTest.district
        )
            .isEqualTo(districtForTest)
    }

    @Test
    fun shouldSetSubPrefectureCodeFromFairObject() {
        val fairForTest = Fair()
        val subPrefectureCodeTest = -7000
        fairForTest.subPrefectureCode = subPrefectureCodeTest
        assertThat(
            fairForTest.subPrefectureCode
        )
            .isEqualTo(subPrefectureCodeTest)
    }

    @Test
    fun shouldSetSubPrefectureNameFromFairObject() {
        val fairForTest = Fair()
        val subPrefectureNameTest = "sub Prefecture Name Test"
        fairForTest.subPrefectureName = subPrefectureNameTest
        assertThat(
            fairForTest.subPrefectureName
        )
            .isEqualTo(subPrefectureNameTest)
    }

    @Test
    fun shouldSetRegion5FromFairObject() {
        val fairForTest = Fair()
        val region5Test = "regiao 5 Test"
        fairForTest.region5 = region5Test
        assertThat(
            fairForTest.region5
        )
            .isEqualTo(region5Test)
    }

    @Test
    fun shouldSetRegion8FromFairObject() {
        val fairForTest = Fair()
        val region8Test = "regiao 8 Test"
        fairForTest.region8 = region8Test
        assertThat(
            fairForTest.region8
        )
            .isEqualTo(region8Test)
    }

    @Test
    fun shouldSetFairNameFromFairObject() {
        val fairForTest = Fair()
        val fairNameTest = "Fair Name Test"
        fairForTest.fairName = fairNameTest
        assertThat(
            fairForTest.fairName
        )
            .isEqualTo(fairNameTest)
    }

    @Test
    fun shouldSetRegisterFromFairObject() {
        val fairForTest = Fair()
        val registerTest = "Register Test"
        fairForTest.register = registerTest
        assertThat(
            fairForTest.register
        )
            .isEqualTo(registerTest)
    }

    @Test
    fun shouldSetPublicPlaceFromFairObject() {
        val fairForTest = Fair()
        val publicPlaceTest = "Public Place Test"
        fairForTest.publicPlace = publicPlaceTest
        assertThat(
            fairForTest.publicPlace
        )
            .isEqualTo(publicPlaceTest)
    }

    @Test
    fun shouldSetNumberFromFairObject() {
        val fairForTest = Fair()
        val numberTest = "Number Test"
        fairForTest.number = numberTest
        assertThat(
            fairForTest.number
        )
            .isEqualTo(numberTest)
    }

    @Test
    fun shouldSetNeighborhoodFromFairObject() {
        val fairForTest = Fair()
        val neighborhoodTest = "Neighborhood Test"
        fairForTest.neighborhood = neighborhoodTest
        assertThat(
            fairForTest.neighborhood
        )
            .isEqualTo(neighborhoodTest)
    }

    @Test
    fun shouldSetReferenceFromFairObject() {
        val fairForTest = Fair()
        val referenceTest = "Reference Test"
        fairForTest.reference = referenceTest
        assertThat(
            fairForTest.reference
        )
            .isEqualTo(referenceTest)
    }

    @Test
    fun shouldSetAreaPFromFairObject() {
        val fairForTest = Fair()
        val areapTest = BigInteger.valueOf(-9000)
        fairForTest.areap = areapTest
        assertThat(
            fairForTest.areap
        )
            .isEqualTo(areapTest)
    }
}