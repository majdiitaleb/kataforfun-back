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
    fun whenNoMatchIsFound_Should_Return_Number(){
      val result =kataTestService.convertNumber(3);
        assertEquals(result,"Kata");
    }


}
