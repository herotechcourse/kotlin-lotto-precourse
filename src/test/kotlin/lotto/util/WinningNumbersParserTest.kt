package lotto.util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersParserTest {

    private val winningNumbersParser = WinningNumbersParser()

    @Test
    fun `throws an exception when input is empty`() {
        assertThrows<IllegalArgumentException> {
            winningNumbersParser.parse("")
        }
    }

    @Test
    fun `throws an exception when input is separated with spaces instead of commas`() {
        assertThrows<IllegalArgumentException> {
            winningNumbersParser.parse("1 2 3 4 5 6")
        }
    }

    @Test
    fun `throws an exception when input is not a number`() {
        assertThrows<IllegalArgumentException> {
            winningNumbersParser.parse("a,b,c")
        }
    }

    @Test
    fun `throws an exception when winning numbers contains number out of range`() {
        assertThrows<IllegalArgumentException> {
            winningNumbersParser.parse("0,2,3,4,5,6")
        }
        assertThrows<IllegalArgumentException> {
            winningNumbersParser.parse("1,2,3,4,5,46")
        }
    }

    @Test
    fun `throws an exception when winning numbers are not exactly 6`() {
        assertThrows<IllegalArgumentException> {
            winningNumbersParser.parse("1,2,3,4,5")
        }

        assertThrows<IllegalArgumentException> {
            winningNumbersParser.parse("1,2,3,4,5,6,7")
        }
    }

    @Test
    fun `throws an exception when there are duplicate numbers`() {
        assertThrows<IllegalArgumentException> {
            winningNumbersParser.parse("1,2,3,4,5,5")
        }
    }

    @Test
    fun `successfully parses valid winning numbers`() {
        val result = winningNumbersParser.parse("1,2,3,4,5,45")
        assert(result == listOf(1, 2, 3, 4, 5, 45))
    }

    @Test
    fun `successfully parses valid winning numbers with whitespace`() {
        val result = winningNumbersParser.parse(" 1, 2, 3, 4, 5, 6 ")
        assert(result == listOf(1, 2, 3, 4, 5, 6))
    }
}