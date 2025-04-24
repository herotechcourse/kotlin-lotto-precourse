package lotto.display

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class WinningNumbersDisplayTest {

    @Test
    fun `prints the entered amount`() {
        val output = ByteArrayOutputStream()
        System.setOut(PrintStream(output))

        WinningNumbersDisplay().show(listOf(6, 7, 8, 9, 10, 11))

        Assertions.assertEquals("Winning Numbers: [6, 7, 8, 9, 10, 11]", output.toString().trim())
    }
}