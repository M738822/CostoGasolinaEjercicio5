import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.semantics.getOrNull
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.mexiti.costogasolina.CostGasLayout
import com.mexiti.costogasolina.ui.theme.CostoGasolinaTheme
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.assertTrue

//Código Actualizado - nueva prueba de instrumentación

class CalcularMontoUITest2 {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calcular_Monto_22_35_40() {
        composeTestRule.setContent { CostoGasolinaTheme { CostGasLayout() } }

        val fields = composeTestRule.onAllNodes(hasSetTextAction(), useUnmergedTree = true)

        fields.printToLog("TEXT_FIELDS")

        fields[0].performClick()
        fields[0].performTextInput("22.35")
        composeTestRule.waitForIdle()

        fields[1].performClick()
        fields[1].performTextInput("40")
        composeTestRule.waitForIdle()

        composeTestRule.onRoot(useUnmergedTree = true).printToLog("TREE")

        val montoNodes = composeTestRule.onAllNodes(
            hasText("Monto Total:", substring = true), useUnmergedTree = true
        )

        val found = montoNodes.fetchSemanticsNodes().any { node ->
            val texts = node.config.getOrNull(SemanticsProperties.Text)
            val joined = texts?.joinToString(" ") { it.text } ?: ""
            joined.contains("894")
        }

        assertTrue(
            "No se encontró el monto calculado (894) en los nodos 'Monto Total'. Revisa Logcat (TEXT_FIELDS/TREE).",
            found
        )
    }
}

