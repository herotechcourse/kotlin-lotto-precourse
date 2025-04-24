package lotto.display

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ProfitDisplayTest {

    @Test
    fun `prints the return rate correctly`() {
        val output = ByteArrayOutputStream()
        System.setOut(PrintStream(output))

        // Given the return rate is 62.5
        ProfitDisplay().displayReturnRate(62.5)

        // Check if the output matches the expected format
        Assertions.assertEquals("Total return rate is 62.5%.", output.toString().trim())
    }

    @Test
    fun `prints the return rate with one decimal place`() {
        val output = ByteArrayOutputStream()
        System.setOut(PrintStream(output))

        // Given the return rate is 62.49 (will be rounded to 62.5)
        ProfitDisplay().displayReturnRate(62.49)

        // Check if the output is correctly rounded
        Assertions.assertEquals("Total return rate is 62.5%.", output.toString().trim())
    }
}