package com.kata.kataforfun.controllers

import com.kata.kataforfun.services.KataForFunService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/kata-for-fun")
class KataForFunController(private val kataForFunService: KataForFunService) {

    @GetMapping("/{inputNumber}", produces = [MediaType.APPLICATION_JSON_VALUE])
    @CrossOrigin(origins = ["http://localhost:8080", "http://localhost:4200"])
    fun convertNumber(@PathVariable(name = "inputNumber") inputNumber: Int): ResultDto? {
        return kataForFunService.convertNumber(inputNumber)?.let { ResultDto(it) }
    }

    data class ResultDto(val result: String)

}

