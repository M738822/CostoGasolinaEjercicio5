package com.mexiti.costogasolina

import org.junit.Test
import java.text.NumberFormat
import org.junit.Assert.assertEquals

//Código Actualizado - nueva prueba unitaria

class CalcularMontoTest2 {

    @Test
    fun calcularMonto20l_22_35() {
        val precio = 22.35
        val cantLitros = 40.0
        val darPropina = false
        val propina = 0.0

        val montoEsperado = NumberFormat.getCurrencyInstance().format(894)
        val montoActual = calcularMonto(precio, cantLitros, darPropina, propina)

        assertEquals("Comparación entre montos", montoEsperado, montoActual)
    }
}

