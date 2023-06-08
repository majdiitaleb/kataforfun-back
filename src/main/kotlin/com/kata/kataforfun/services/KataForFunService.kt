package com.kata.kataforfun.services

import org.springframework.stereotype.Component

@Component
class KataForFunService {

    fun convertNumber(inputNumber: Int): String {

        var stringNumber= inputNumber.toString()
        if(inputNumber % 3 ==0 || stringNumber.contains('3')){
            stringNumber = stringNumber.replace("3","Kata");
        }
        return stringNumber
    }

}