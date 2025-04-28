package lotto.util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseAmountParserTest {

    private val purchaseAmountParser = PurchaseAmountParser()

    @Test
    fun `throws an exception when input is empty`() {
        assertThrows<IllegalArgumentException> {
            purchaseAmountParser.parse("")
        }
    }

    @Test
    fun `throws an exception when input is not a number`() {
        assertThrows<IllegalArgumentException> {
            purchaseAmountParser.parse("abc")
        }
    }

    @Test
    fun `throws an exception when amount is a negative number`() {
        assertThrows<IllegalArgumentException> {
            purchaseAmountParser.parse("-1000")
        }
    }

    @Test
    fun `throws an exception when amount is zero`() {
        assertThrows<IllegalArgumentException> {
            purchaseAmountParser.parse("0")
        }
    }

    @Test
    fun `throws an exception when amount is not divisible by 1000`() {
        assertThrows<IllegalArgumentException> {
            purchaseAmountParser.parse("500")
        }
    }

    @Test
    fun `throws an exception when input has trailing whitespace`() {
        assertThrows<IllegalArgumentException> {
            purchaseAmountParser.parse("8000 ")
        }

        assertThrows<IllegalArgumentException> {
            purchaseAmountParser.parse(" 8000")
        }

        assertThrows<IllegalArgumentException> {
            purchaseAmountParser.parse(" 8000 ")
        }
    }

    @Test
    fun `successfully parses valid amount`() {
        val result = purchaseAmountParser.parse("8000")
        assert(result == 8000)
    }
}