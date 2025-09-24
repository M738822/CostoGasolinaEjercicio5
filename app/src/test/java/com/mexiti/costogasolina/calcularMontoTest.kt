package com.mexiti.costogasolina

import org.junit.Test
import java.text.NumberFormat
import org.junit.Assert.assertEquals

class CalcularMontoTest {

    @Test
    fun calcularMonto20l_24_93() {
        val precio = 24.93
        val cantLitros = 20.0
        val darPropina = false
        val propina = 0.0

        val montoEsperado = NumberFormat.getCurrencyInstance().format(498.6)
        val montoActual = calcularMonto(precio, cantLitros, darPropina, propina)

        assertEquals("Comparación entre montos", montoEsperado, montoActual)
    }
}
