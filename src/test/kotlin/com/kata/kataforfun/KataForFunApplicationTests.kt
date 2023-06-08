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

    @Test
    fun whenNoMatch3_5_7_IsFound_Should_Return_Digit(){
        val result =kataTestService.convertNumber(1);
        assertEquals(result,"1");
    }
    @Test
    fun whenJust_5_IsFound_Should_Return_ForFor(){
        val result =kataTestService.convertNumber(5);
        assertEquals(result,"ForFor");
    }

    @Test
    fun whenJust_7_IsFound_Should_Return_Fun(){
        val result =kataTestService.convertNumber(7);
        assertEquals(result,"Fun");
    }

    @Test
    fun whenNumberDivisibleBy3_IsFound_Should_Return_Kata(){
        val result =kataTestService.convertNumber(9);
        assertEquals(result,"Kata");
    }

    @Test
    fun whenNumberDivisibleBy3_and_contain_5_IsFound_Should_Return_KataFor(){
        val result =kataTestService.convertNumber(51);
        assertEquals(result,"KataFor");
    }




}
