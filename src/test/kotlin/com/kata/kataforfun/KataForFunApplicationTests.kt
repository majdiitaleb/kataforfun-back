package com.kata.kataforfun

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import com.kata.kataforfun.services.KataForFunService
import org.junit.jupiter.api.Assertions.assertEquals

@SpringBootTest
class KataForFunApplicationTests {


    private val  kataTestService: KataForFunService = KataForFunService()
    @Test
    fun contextLoads() {

    }

    @Test
    fun whenJust_3_IsFound_Should_Return_KataKata(){
        val result =kataTestService.convertNumber(3);
        assertEquals(result,"KataKata");
    }
    @Test
    fun whenJust_3_IsFound_With_Int_Should_Return_KataInt(){
        val result =kataTestService.convertNumber(31);
        assertEquals(result,"Kata1");
    }
    @Test
    fun whenMatch_3_IsFound_Should_Return_KataKataKata(){
      val result =kataTestService.convertNumber(33);
        assertEquals(result,"KataKataKata");
    }





}
