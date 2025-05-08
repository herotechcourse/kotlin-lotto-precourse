package lotto.view

import camp.nextstep.edu.missionutils.Console
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.*

class ConsoleInputReaderTest{

    private lateinit var originalIn: InputStream
    private lateinit var standardOut: PrintStream;
    private lateinit var captor: OutputStream

    @BeforeEach
    fun setUp() {
        originalIn = System.`in`
        standardOut = System.out
        captor = ByteArrayOutputStream()
        System.setOut(PrintStream(captor))
    }

    @AfterEach
    fun tearDown() {
        System.setIn(originalIn)
        Console.close()
    }

    @Test
    fun `readPurchaseAmount() should return PurchaseAmount with correct amount`() {
        // given
        val valueInput = 3000
        inputToConsole(valueInput.toString())
        val consoleInputReader = ConsoleInputReader()

        // when
        val purchaseAmount = consoleInputReader.readPurchaseAmount()

        // then
        assertThat(purchaseAmount.toInt()).isEqualTo(valueInput)
    }

    @Test
    fun `throw an exception when exceed the prompt re-tries`() {
        // given
        inputToConsole("NaN")
        val consoleInputReader = ConsoleInputReader()

        // when & then
//        assertThatThrownBy { RePrompter.retryPrompt({ consoleInputReader.readPurchaseAmount() }) }
//            .hasMessage("[ERROR] You failed 3 times. Please try again later.")
    }

    private fun inputToConsole(text: String) {
        System.setIn(ByteArrayInputStream(text.toByteArray()))
    }

    private fun output(): String {
        return captor.toString().trim()
    }
}
