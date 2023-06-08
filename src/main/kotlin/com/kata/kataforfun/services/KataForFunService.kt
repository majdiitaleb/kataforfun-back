package com.kata.kataforfun.services

import org.springframework.stereotype.Component
import java.lang.StringBuilder

@Component
class KataForFunService {

    fun convertNumber(inputNumber: Int): String {

        val stringNumber= inputNumber.toString()
        var result = StringBuilder();
        if(inputNumber % 3 ==0 ){
           result.append("Kata")
        }

        for(digit in stringNumber){
            when(digit){
                '3' -> result.append("Kata")
                else -> result.append(digit)
            }
        }
        return result.toString()
    }

}