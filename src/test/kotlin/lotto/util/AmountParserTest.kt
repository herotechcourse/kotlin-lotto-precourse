package lotto.util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AmountParserTest {

    private val amountParser = AmountParser()

    @Test
    fun `throws an exception when input is empty`() {
        assertThrows<IllegalArgumentException> {
            amountParser.parse("")
        }
    }

    @Test
    fun `throws an exception when input is not a number`() {
        assertThrows<IllegalArgumentException> {
            amountParser.parse("abc")
        }
    }

    @Test
    fun `throws an exception when input is a negative number`() {
        assertThrows<IllegalArgumentException> {
            amountParser.parse("-1000")
        }
    }

    @Test
    fun `throws an exception when input is zero`() {
        assertThrows<IllegalArgumentException> {
            amountParser.parse("0")
        }
    }

    @Test
    fun `throws an exception when input is not divisible by 1000`() {
        assertThrows<IllegalArgumentException> {
            amountParser.parse("500")
        }
    }

    @Test
    fun `successfully parses valid amount`() {
        val result = amountParser.parse("8000")
        assert(result == 8000)
    }
}