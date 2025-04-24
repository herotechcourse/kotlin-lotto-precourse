package lotto.display

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class BonusNumberDisplayTest {

    @Test
    fun `prints the entered amount`() {
        val output = ByteArrayOutputStream()
        System.setOut(PrintStream(output))

        BonusNumberDisplay().show(6)

        Assertions.assertEquals("Bonus Number entered: 6", output.toString())
    }
}