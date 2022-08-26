package br.com.fairDemo.infrastructure.http.controller

import br.com.fairDemo.entities.Fair
import br.com.fairDemo.infrastructure.http.controller.createFair.CreateFairRequest
import br.com.fairDemo.infrastructure.http.controller.createFair.CreateFairResponse
import br.com.fairDemo.infrastructure.http.controller.getFair.GetFairFilter
import br.com.fairDemo.infrastructure.http.controller.getFair.GetFairsResponse
import br.com.fairDemo.infrastructure.http.controller.updateFair.UpdateFairRequest
import br.com.fairDemo.infrastructure.http.controller.updateFair.UpdateFairResponse
import br.com.fairDemo.useCases.FairCRUDService
import br.com.fairDemo.useCases.utils.GetFairCriteria
import br.com.fairDemo.useCases.ImportFileFromURL
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController("/fair")
class FairController (
    private val importFileFromURL: ImportFileFromURL,
    private val fairCRUDServices: FairCRUDService
) {

    @GetMapping("/")
    fun helloWorld(): String{
        return "hello"
    }

    @PostMapping("/import-from-website")
    fun importFromWebSite(@RequestParam url: String){
        return importFileFromURL.execute(url)
    }

    @PostMapping("/", consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun createFair(@RequestBody fairRequest: CreateFairRequest): CreateFairResponse {
        val newFair = fairRequest.toFairDomain()
        return CreateFairResponse.fromFairDomain(fairCRUDServices.create(newFair))
    }

    @DeleteMapping("/{fairId}", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteFair(@PathVariable fairId: Long) {
        fairCRUDServices.delete(fairId)
    }

    @PutMapping("/{fairId}", consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateFair(@PathVariable fairId: Long, @RequestBody fairRequest: UpdateFairRequest): UpdateFairResponse {
        val fair = fairRequest.toFairDomain()
        return UpdateFairResponse.fromFairDomain(fairCRUDServices.update(fairId, fair))
    }

    @GetMapping("/", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getFairsByCriteria(@RequestParam filter: GetFairFilter): List<GetFairsResponse>{
        val criteria: GetFairCriteria = filter.toFairCriteria()
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