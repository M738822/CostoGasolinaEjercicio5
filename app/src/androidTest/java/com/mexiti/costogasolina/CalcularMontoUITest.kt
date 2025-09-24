package com.mexiti.costogasolina

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.mexiti.costogasolina.ui.theme.CostoGasolinaTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat
import java.util.Locale

class CalcularMontoUITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calcular_Monto_201_24_94() {
        composeTestRule.setContent { CostoGasolinaTheme { CostGasLayout() } }

        // Si alguna vez falla, descomenta para ver el árbol:
        // composeTestRule.onRoot(useUnmergedTree = true).printToLog("TREE")

        val fields = composeTestRule.onAllNodes(
            hasSetTextAction(), useUnmergedTree = true
        )

        // Campo 0: precio por litro
        fields[0].performClick()
        fields[0].performTextInput("23.94")

        // Campo 1: litros
        fields[1].performClick()
        fields[1].performTextInput("20")

        val esperado = NumberFormat.getCurrencyInstance(Locale("es","MX"))
            .format(23.94 * 20)

        composeTestRule.onNode(hasText("Monto Total: $esperado")).assertExists()
    }
}