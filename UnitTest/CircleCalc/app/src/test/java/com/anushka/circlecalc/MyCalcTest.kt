package com.anushka.circlecalc

import org.junit.Assert.*
import org.junit.Test

class MyCalcTest {

    private lateinit var myCalc: MyCalc

    companion object {
        const val DELTA = 1e-15
    }


    @Test
    fun calculateCircumference_radiusGiven_returnsCorrectResult() {
        myCalc = MyCalc()
        val result = myCalc.calculateCircumference(2.1)
        assertEquals(13.188, result, DELTA)
    }

    @Test
    fun calculateCircumference_zeroRadius_returnsConrrectResult() {
        myCalc = MyCalc()
        val result = myCalc.calculateCircumference(0.0)
        assertEquals(0.0, result, DELTA)
    }

}