package com.anushka.circlecalc

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class CalcViewModelTest {

    private lateinit var calcViewModel: CalcViewModel
    private lateinit var calculations: Calculations

    companion object {
        const val DELTA = 1e-15
    }

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        calculations = Mockito.mock(Calculations::class.java)
        Mockito.`when`(calculations.calculateArea(2.1)).thenReturn(13.8474)
        Mockito.`when`(calculations.calculateCircumference(1.0)).thenReturn(6.28)
        calcViewModel = CalcViewModel(calculations)
    }

    @Test
    fun calculateArea_radiusSent_updateLiveData() {
        calcViewModel.calculateArea(2.1)
        val result = calcViewModel.areaValue.value!!.toDouble()
        assertEquals(13.8474, result, DELTA)
    }

    @Test
    fun calculateCircumference_radiusRadius_updateLiveData() {
        calcViewModel.calculateCircumference(1.0)
        val result = calcViewModel.circumferenceValue.value!!.toDouble()
        assertEquals(6.28, result, MyCalcTest.DELTA)
    }

}