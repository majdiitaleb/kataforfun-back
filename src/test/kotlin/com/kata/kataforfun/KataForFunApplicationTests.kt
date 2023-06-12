package com.kata.kataforfun

import com.kata.kataforfun.services.KataForFunService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class KataForFunApplicationTests {


    private val  kataTestService: KataForFunService = KataForFunService()
    @Test
    fun contextLoads() {

    }

    @Test
    fun whenJust_3_IsFound_Should_Return_KataKata(){
        val result =kataTestService.convertNumber(3);
        assertEquals(result, "KataKata");
    }

    @Test
    fun whenMultiplication_IsFound_Should_Return_Kata(){
        val result =kataTestService.convertNumber(3 * 3);
        assertEquals(result, "Kata");
    }

    @Test
    fun whenJust_3_IsFound_With_Int_Should_Return_KataInt(){
        val result =kataTestService.convertNumber(31);
        assertEquals(result, "Kata1");
    }
    @Test
    fun whenMatch_3_IsFound_Should_Return_KataKataKata(){
      val result =kataTestService.convertNumber(33);
        assertEquals(result, "KataKataKata");
    }

    @Test
    fun whenNoMatch3_5_7_IsFound_Should_Return_Digit(){
        val result =kataTestService.convertNumber(1);
        assertEquals(result, "1");
    }
    @Test
    fun whenJust_5_IsFound_Should_Return_ForFor(){
        val result =kataTestService.convertNumber(5);
        assertEquals(result, "ForFor");
    }

    @Test
    fun whenJust_7_IsFound_Should_Return_Fun(){
        val result =kataTestService.convertNumber(7);
        assertEquals(result, "Fun");
    }

    @Test
    fun whenNumberDivisibleBy3_IsFound_Should_Return_Kata(){
        val result =kataTestService.convertNumber(9);
        assertEquals(result, "Kata");
    }

    @Test
    fun whenNumberDivisibleBy3_and_contain_5_IsFound_Should_Return_KataFor(){
        val result =kataTestService.convertNumber(51);
        assertEquals(result, "KataFor");
    }


    @Test
    fun whenNumberNotDivisibleBy3or5_And_contain_5and3_Should_Return_ForKata(){
        val result =kataTestService.convertNumber(53);
        assertEquals(result, "ForKata");
    }
    @Test
    fun whenNumberDivisibleBy3AndContain7_Should_Return_KataFun(){
        val result =kataTestService.convertNumber(27);
        assertEquals(result, "KataFun");
    }

    @Test
    fun whenNumberDivisibleBy3And5_AndContain_5_Should_Return_KataForFor(){
        val result =kataTestService.convertNumber(15);
        assertEquals(result, "KataForFor");
    }

    @Test
    fun whenNgeationIsFound_Then_Return_Exception(){
        val dividend = 15
        val divisor = 3
        val expected = dividend - dividend / divisor * divisor

        val result =kataTestService.convertNumber(expected);
        assertEquals(result, "KataFor");
    }

    @Test
    fun whenNull_Then_Return_Null(){
        val result =kataTestService.convertNumber(null);
        assertEquals(result, null)
    }

    @Test
    fun testConvertNumber_NullInput() {
        // Arrange
        val inputNumber: Int? = null

        // Act
        val result = kataTestService.convertNumber(inputNumber)

        // Assert
        assertNull(result)
    }
    @Test
    fun testConvertNumber_NegativeInput() {
        // Arrange
        val inputNumber = -10
        val expected = "For"
        // Act
        val result = kataTestService.convertNumber(inputNumber)

        // Assert
        assertEquals(expected, result)
    }
    @Test
    fun testConvertNumber_PositiveNotDivisibleBy3Or5() {
        // Arrange
        val inputNumber = 17
        val expected = "1Fun"

        // Act
        val result = kataTestService.convertNumber(inputNumber)


        // Assert
        assertNotNull(result)
        assertEquals(expected, result)
    }
    @Test
    fun testConvertNumber_PositiveDivisibleBy3() {
        // Arrange
        val inputNumber = 9
        val expected = "Kata"

        // Act
        val result = kataTestService.convertNumber(inputNumber)

        // Assert
        assertNotNull(result)
        assertEquals(expected, result)
    }

    @Test
    fun testConvertNumber_PositiveDivisibleBy5() {
        // Arrange
        val inputNumber = 25
        val expected = "ForFor"

        // Act
        val result = kataTestService.convertNumber(inputNumber)

        // Assert
        assertNotNull(result)
        assertEquals(expected, result)
    }

    @Test
    fun testConvertNumber_PositiveDivisibleBy3And5() {
        // Arrange
        val inputNumber = 30
        val expected = "KataForKata"

        // Act
        val result = kataTestService.convertNumber(inputNumber)

        // Assert
        assertEquals(expected, result)
    }

    @Test
    fun testConvertNumber_PositivenotDivisibleByAny5Or3() {
        // Arrange
        val inputNumber = 88
        val expected = "88"

        // Act
        val result = kataTestService.convertNumber(inputNumber)

        // Assert
        assertEquals(expected, result)
    }

    @Test
    fun testConvertNumber_NegativeDivisibleBy3And5() {
        // Arrange
        val inputNumber = -30
        val expected = "KataForKata"

        // Act
        val result = kataTestService.convertNumber(inputNumber)

        // Assert
        assertEquals(expected, result)
    }


}
