package lotto

import camp.nextstep.edu.missionutils.Console
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.*
import java.io.ByteArrayInputStream
import java.io.InputStream

class ConsoleInputReaderTest{

    private lateinit var originalIn: InputStream

    @BeforeEach
    fun setUp() {
        originalIn = System.`in`
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
    fun `readPurchaseAmount() should throw IllegalArgumentException when input not a number value`() {
        // given
        val invalidInput = "NaN"
        inputToConsole(invalidInput)
        val consoleInputReader = ConsoleInputReader()

        // when & then
        assertThatThrownBy { consoleInputReader.readPurchaseAmount() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERR] Purchase amount must be a number. Please enter again.")
    }

    private fun inputToConsole(text: String) {
        System.setIn(ByteArrayInputStream(text.toByteArray()))
    }
}
