package lotto.display

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class PurchaseAmountDisplayTest {

    @Test
    fun `prints the entered amount`() {
        val output = ByteArrayOutputStream()
        System.setOut(PrintStream(output))

        PurchaseAmountDisplay().show(3000)

        assertEquals("Purchase amount entered: 3000", output.toString())
    }
}