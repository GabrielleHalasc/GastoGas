package com.example.conversormoedas

import junit.framework.TestCase.assertEquals
import org.junit.Test
import presentation.ResultActivityViewModel

class ResultActivityViewModelTest {

    @Test
    fun result() {
        val underTest = ResultActivityViewModel()
        val result = underTest.gasto(distancia = 100f, 80f, 2f)
        assertEquals(2.5.toBigDecimal(), result.toBigDecimal())


    }

}


