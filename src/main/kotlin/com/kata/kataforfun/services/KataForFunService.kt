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
        if(inputNumber % 5 ==0 ){
            result.append("For")
        }
        val bool: Boolean=   inputNumber % 3 ==0 || inputNumber % 5 ==0

        for(digit in stringNumber){

            when(digit){
                '3' -> result.append("Kata")
                '5' -> result.append("For")
                '7' -> result.append("Fun")
                else -> if(!bool){
                    result.append(digit)

                }

            }
        }
        return result.toString()
    }

}