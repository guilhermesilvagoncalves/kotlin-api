package br.com.fairDemo.infrastructure.http.controller

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.infrastructure.http.controller.createFair.CreateFairRequest
import br.com.fairDemo.infrastructure.http.controller.createFair.CreateFairResponse
import br.com.fairDemo.infrastructure.http.controller.getFair.GetFairFilter
import br.com.fairDemo.infrastructure.http.controller.getFair.GetFairsResponse
import br.com.fairDemo.infrastructure.http.controller.updateFair.UpdateFairRequest
import br.com.fairDemo.useCases.FairCRUDService
import br.com.fairDemo.useCases.utils.GetFairCriteria
import br.com.fairDemo.useCases.errors.FairNotFound
import org.springframework.data.repository.query.Param
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController("/fair")
class FairController (
    private val fairCRUDServices: FairCRUDService
) {
    @PostMapping("/", consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createFair(@RequestBody fairRequest: CreateFairRequest):  ResponseEntity<CreateFairResponse> {
        val newFair = fairRequest.toFairDomain()
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(
                CreateFairResponse.fromFairDomain(
                    fairCRUDServices.create(newFair)))
    }

    @DeleteMapping("/{fairId}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deleteFair(@PathVariable fairId: Long): ResponseEntity<String> {
        return try{
            fairCRUDServices.delete(fairId)
            ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build()
        } catch (e: FairNotFound){
            ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.message)
        } catch (e: Exception) {
            ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(e.message)
        }
    }

    @PutMapping("/{fairId}", consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun updateFair(@PathVariable fairId: Long, @RequestBody fairRequest: UpdateFairRequest): ResponseEntity<String> {
        val fair = fairRequest.toFairDomain()
        return try{
            fairCRUDServices.update(fairId, fair)
            ResponseEntity.noContent().build()
        } catch (e: FairNotFound){
            ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(e.message)
        } catch (e: Exception) {
            ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(e.message)
        }
    }

    @GetMapping("/", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getFairsByCriteria(
        @RequestParam(required = false) distrito: String?,
        @RequestParam(required = false) regiao5: String?,
        @RequestParam(required = false) nomeFeira: String?,
        @RequestParam(required = false) bairro: String?
    ): List<GetFairsResponse>{
        val criteria = GetFairCriteria(distrito, regiao5, nomeFeira, bairro)
        val fairList = fairCRUDServices.getFairByCriteria(criteria)
        return buildGetFairsByCriteriaResponseList(fairList)
    }

    private fun buildGetFairsByCriteriaResponseList(fairList: List<Fair>): List<GetFairsResponse> {
        val getFairResponseList = ArrayList<GetFairsResponse>()
        fairList.forEach{
            getFairResponseList.add(GetFairsResponse.fromFairDomain(it))
        }
        return getFairResponseList
    }
}