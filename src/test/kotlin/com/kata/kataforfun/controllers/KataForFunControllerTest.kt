package com.kata.kataforfun.controllers

import com.kata.kataforfun.services.KataForFunService
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.status
import org.springframework.test.web.client.match.MockRestRequestMatchers.content
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest(KataForFunController::class)
 class KataForFunControllerTest {

    @MockBean
    private lateinit var service: KataForFunService

    @Autowired
    private lateinit var mvc: MockMvc

    @Test
    fun testConvertNumber(){

        BDDMockito.given(service.convertNumber(Mockito.anyInt())).willReturn("KataForFun")

        mvc.perform(MockMvcRequestBuilders.get("/kata-for-fun/33"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("result").value("KataForFun"))



    }

}