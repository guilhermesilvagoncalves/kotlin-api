package br.com.fairDemo.infrastructure.database

import br.com.fairDemo.fixtures.FairFixture
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
class FairDAOTests {

    var fairDAO: FairDAO = FairDAO(
        id = FairFixture.getFairDomainForTests().id,
        long = FairFixture.getFairDomainForTests().longitude.toString(),
        lat = FairFixture.getFairDomainForTests().latitude.toString(),
        setcens = FairFixture.getFairDomainForTests().setcens.toString(),
        areap = FairFixture.getFairDomainForTests().areap.toString(),
        coddist = FairFixture.getFairDomainForTests().districtCode.toString(),
        distrito = FairFixture.getFairDomainForTests().district,
        codsubpref = FairFixture.getFairDomainForTests().subPrefectureCode.toString(),
        subprefe = FairFixture.getFairDomainForTests().subPrefectureName,
        regiao5 = FairFixture.getFairDomainForTests().region5,
        regiao8 = FairFixture.getFairDomainForTests().region8,
        nomeFeira = FairFixture.getFairDomainForTests().fairName,
        registro = FairFixture.getFairDomainForTests().register,
        logradouro = FairFixture.getFairDomainForTests().publicPlace,
        numero = FairFixture.getFairDomainForTests().number,
        bairro = FairFixture.getFairDomainForTests().neighborhood,
        referencia = FairFixture.getFairDomainForTests().reference
    )

    @Test
    fun shouldBuildFairDAOWithoutDefaultParameters() {
        val fairDAOWithoutDefaultParameters = FairDAO(
            long = FairFixture.getFairDomainForTests().longitude.toString(),
            lat = FairFixture.getFairDomainForTests().latitude.toString(),
            setcens = FairFixture.getFairDomainForTests().setcens.toString(),
            areap = FairFixture.getFairDomainForTests().areap.toString(),
            distrito = FairFixture.getFairDomainForTests().districtCode.toString(),
            coddist = FairFixture.getFairDomainForTests().district,
            codsubpref = FairFixture.getFairDomainForTests().subPrefectureCode.toString(),
            subprefe = FairFixture.getFairDomainForTests().subPrefectureName,
            regiao5 = FairFixture.getFairDomainForTests().region5,
            regiao8 = FairFixture.getFairDomainForTests().region8,
            nomeFeira = FairFixture.getFairDomainForTests().fairName,
            registro = FairFixture.getFairDomainForTests().register,
            logradouro = FairFixture.getFairDomainForTests().publicPlace
        )

        assertThat(
            fairDAOWithoutDefaultParameters)
            .isInstanceOf(FairDAO::class.java)
    }


    @Test
    fun shouldBuildFairDAO() {
        assertThat(
            fairDAO)
            .isInstanceOf(FairDAO::class.java)
    }

    @Test
    fun shouldReturnIdFromFairDAOObject() {
        assertThat(
            fairDAO.id
        )
            .isEqualTo(FairFixture.getFairDomainForTests().id)
    }

    @Test
    fun shouldReturnLongitudeFromFairDAOObject() {
        assertThat(
            fairDAO.long
        )
            .isEqualTo(FairFixture.getFairDomainForTests().longitude.toString())
    }

    @Test
    fun shouldReturnLatitudeFromFairDAOObject() {
        assertThat(
            fairDAO.lat
        )
            .isEqualTo(FairFixture.getFairDomainForTests().latitude.toString())
    }

    @Test
    fun shouldReturnSetcensFromFairDAOObject() {
        assertThat(
            fairDAO.setcens
        )
            .isEqualTo(FairFixture.getFairDomainForTests().setcens.toString())
    }

    @Test
    fun shouldReturnAreapFromFairDAOObject() {
        assertThat(
            fairDAO.areap
        )
            .isEqualTo(FairFixture.getFairDomainForTests().areap.toString())
    }

    @Test
    fun shouldReturnDistrictCodeFromFairDAOObject() {
        assertThat(
            fairDAO.coddist
        )
            .isEqualTo(FairFixture.getFairDomainForTests().districtCode.toString())
    }

    @Test
    fun shouldReturnSubPrefectureCodeFromFairDAOObject() {
        assertThat(
            fairDAO.codsubpref
        )
            .isEqualTo(FairFixture.getFairDomainForTests().subPrefectureCode.toString())
    }

    @Test
    fun shouldReturnSubPrefectureNameFromFairDAOObject() {
        assertThat(
            fairDAO.subprefe
        )
            .isEqualTo(FairFixture.getFairDomainForTests().subPrefectureName)
    }

    @Test
    fun shouldReturnRegion5FromFairDAOObject() {
        assertThat(
            fairDAO.regiao5
        )
            .isEqualTo(FairFixture.getFairDomainForTests().region5)
    }

    @Test
    fun shouldReturnFairDAONameFromFairDAOObject() {
        assertThat(
            fairDAO.nomeFeira
        )
            .isEqualTo(FairFixture.getFairDomainForTests().fairName)
    }

    @Test
    fun shouldReturnRegisterFromFairDAOObject() {
        assertThat(
            fairDAO.registro
        )
            .isEqualTo(FairFixture.getFairDomainForTests().register)
    }

    @Test
    fun shouldReturnRegion8FromFairDAOObject() {
        assertThat(
            fairDAO.regiao8
        )
            .isEqualTo(FairFixture.getFairDomainForTests().region8)
    }

    @Test
    fun shouldReturnNeighborhoodFromFairDAOObject() {
        assertThat(
            fairDAO.bairro
        )
            .isEqualTo(FairFixture.getFairDomainForTests().neighborhood)
    }

    @Test
    fun shouldReturnNumberFromFairDAOObject() {
        assertThat(
            fairDAO.numero
        )
            .isEqualTo(FairFixture.getFairDomainForTests().number)
    }

    @Test
    fun shouldReturnReferenceFromFairDAOObject() {
        assertThat(
            fairDAO.referencia
        )
            .isEqualTo(FairFixture.getFairDomainForTests().reference)
    }

    @Test
    fun shouldReturnPublicPlaceFromFairDAOObject() {
        assertThat(
            fairDAO.logradouro
        )
            .isEqualTo(FairFixture.getFairDomainForTests().publicPlace)
    }

    @Test
    fun shouldReturnDistrictFromFairDAOObject() {
        assertThat(
            fairDAO.distrito
        )
            .isEqualTo(FairFixture.getFairDomainForTests().district)
    }

    @Test
    fun shouldSetLongitudeFromFairDAOObject() {
        val fairDAOForTest = FairDAO()
        val longitudeForTest = "-1000"
        fairDAOForTest.long = longitudeForTest
        assertThat(
            fairDAOForTest.long
        )
            .isEqualTo(longitudeForTest)
    }

    @Test
    fun shouldSetLatitudeFromFairDAOObject() {
        val fairDAOForTest = FairDAO()
        val latitudeForTest = "-2000"
        fairDAOForTest.lat = latitudeForTest
        assertThat(
            fairDAOForTest.lat
        )
            .isEqualTo(latitudeForTest)
    }

    @Test
    fun shouldSetSetcensLatitudeFromFairDAOObject() {
        val fairDAOForTest = FairDAO()
        val setcensForTest = "-3000"
        fairDAOForTest.setcens = setcensForTest
        assertThat(
            fairDAOForTest.setcens
        )
            .isEqualTo(setcensForTest)
    }

    @Test
    fun shouldSetDistrictCodeLatitudeFromFairDAOObject() {
        val fairDAOForTest = FairDAO()
        val districtCodeForTest = "-5000"
        fairDAOForTest.coddist = districtCodeForTest
        assertThat(
            fairDAOForTest.coddist
        )
            .isEqualTo(districtCodeForTest)
    }

    @Test
    fun shouldSetDistrictLatitudeFromFairDAOObject() {
        val fairDAOForTest = FairDAO()
        val districtForTest = "District"
        fairDAOForTest.distrito = districtForTest
        assertThat(
            fairDAOForTest.distrito
        )
            .isEqualTo(districtForTest)
    }

    @Test
    fun shouldSetSubPrefectureCodeFromFairDAOObject() {
        val fairDAOForTest = FairDAO()
        val subPrefectureCodeTest = "-7000"
        fairDAOForTest.codsubpref = subPrefectureCodeTest
        assertThat(
            fairDAOForTest.codsubpref
        )
            .isEqualTo(subPrefectureCodeTest)
    }

    @Test
    fun shouldSetSubPrefectureNameFromFairDAOObject() {
        val fairDAOForTest = FairDAO()
        val subPrefectureNameTest = "sub Prefecture Name Test"
        fairDAOForTest.subprefe = subPrefectureNameTest
        assertThat(
            fairDAOForTest.subprefe
        )
            .isEqualTo(subPrefectureNameTest)
    }

    @Test
    fun shouldSetRegion5FromFairDAOObject() {
        val fairDAOForTest = FairDAO()
        val region5Test = "regiao 5 Test"
        fairDAOForTest.regiao5 = region5Test
        assertThat(
            fairDAOForTest.regiao5
        )
            .isEqualTo(region5Test)
    }

    @Test
    fun shouldSetRegion8FromFairDAOObject() {
        val fairDAOForTest = FairDAO()
        val region8Test = "regiao 8 Test"
        fairDAOForTest.regiao8 = region8Test
        assertThat(
            fairDAOForTest.regiao8
        )
            .isEqualTo(region8Test)
    }

    @Test
    fun shouldSetFairDAONameFromFairDAOObject() {
        val fairDAOForTest = FairDAO()
        val fairNameTest = "FairDAO Name Test"
        fairDAOForTest.nomeFeira = fairNameTest
        assertThat(
            fairDAOForTest.nomeFeira
        )
            .isEqualTo(fairNameTest)
    }

    @Test
    fun shouldSetRegisterFromFairDAOObject() {
        val fairDAOForTest = FairDAO()
        val registerTest = "Register Test"
        fairDAOForTest.registro = registerTest
        assertThat(
            fairDAOForTest.registro
        )
            .isEqualTo(registerTest)
    }

    @Test
    fun shouldSetPublicPlaceFromFairDAOObject() {
        val fairDAOForTest = FairDAO()
        val publicPlaceTest = "Public Place Test"
        fairDAOForTest.logradouro = publicPlaceTest
        assertThat(
            fairDAOForTest.logradouro
        )
            .isEqualTo(publicPlaceTest)
    }

    @Test
    fun shouldSetNumberFromFairDAOObject() {
        val fairDAOForTest = FairDAO()
        val numberTest = "Number Test"
        fairDAOForTest.numero = numberTest
        assertThat(
            fairDAOForTest.numero
        )
            .isEqualTo(numberTest)
    }

    @Test
    fun shouldSetNeighborhoodFromFairDAOObject() {
        val fairDAOForTest = FairDAO()
        val neighborhoodTest = "Neighborhood Test"
        fairDAOForTest.bairro = neighborhoodTest
        assertThat(
            fairDAOForTest.bairro
        )
            .isEqualTo(neighborhoodTest)
    }

    @Test
    fun shouldSetReferenceFromFairDAOObject() {
        val fairDAOForTest = FairDAO()
        val referenceTest = "Reference Test"
        fairDAOForTest.referencia = referenceTest
        assertThat(
            fairDAOForTest.referencia
        )
            .isEqualTo(referenceTest)
    }

    @Test
    fun shouldSetAreaPFromFairDAOObject() {
        val fairDAOForTest = FairDAO()
        val areapTest = "-9000"
        fairDAOForTest.areap = areapTest
        assertThat(
            fairDAOForTest.areap
        )
            .isEqualTo(areapTest)
    }
}