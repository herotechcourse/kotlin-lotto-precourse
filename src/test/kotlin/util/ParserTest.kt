package util

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.assertDoesNotThrow
import org.assertj.core.api.Assertions.assertThat

class ParserTest {
    /**
     * Tests for toPurchaseAmount(input: String)
     * - Parses valid numeric input
     * - Throws if non-numeric or invalid value
     */
    @Test
    fun `returns int when purchase amount is valid`() {
        val result = Parser.toPurchaseAmount("5000")
        assertThat(result).isEqualTo(5000)
    }

    @Test
    fun `throws an exception when purchase amount is non-numeric`() {
        assertThrows<IllegalArgumentException> {
            Parser.toPurchaseAmount("abc")
        }
    }

    @Test
    fun `throws an exception when purchase amount is zero`() {
        assertThrows<IllegalArgumentException> {
            Parser.toPurchaseAmount("0")
        }
    }

    @Test
    fun `throws an exception when purchase amount is not a multiple of 1000`() {
        assertThrows<IllegalArgumentException> {
            Parser.toPurchaseAmount("123")
        }
    }

    /**
     * Tests for toWinningNumbers(input: String)
     * - Parses comma-separated valid numbers into list
     * - Throws for bad format, duplicates, or out-of-range values
     */
    @Test
    fun `returns list of numbers when winning numbers are valid`() {
        val result = Parser.toWinningNumbers("1,2,3,4,5,6")
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `throws an exception when winning numbers include non-numeric value`() {
        assertThrows<IllegalArgumentException> {
            Parser.toWinningNumbers("1,2,3,a,5,6")
        }
    }

    @Test
    fun `throws an exception when winning numbers include duplicates`() {
        assertThrows<IllegalArgumentException> {
            Parser.toWinningNumbers("1,2,3,4,5,5")
        }
    }

    @Test
    fun `throws an exception when winning numbers include out-of-range values`() {
        assertThrows<IllegalArgumentException> {
            Parser.toWinningNumbers("1,2,3,4,5,46")
        }
    }

    /**
     * Tests for toBonusNumber(input: String)
     * - Parses a valid number
     * - Throws for invalid input
     */
    @Test
    fun `returns int when bonus number is valid`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val result = Parser.toBonusNumber("7", winningNumbers)
        assertThat(result).isEqualTo(7)
    }

    @Test
    fun `throws an exception when bonus number is non-numeric`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertThrows<IllegalArgumentException> {
            Parser.toBonusNumber("abc", winningNumbers)
        }
    }

    @Test
    fun `throws an exception when bonus number is out of range`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertThrows<IllegalArgumentException> {
            Parser.toBonusNumber("100", winningNumbers)
        }
    }


    @Test
    fun `throws an exception when bonus number is duplicated with winning numbers`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertThrows<IllegalArgumentException> {
            Parser.toBonusNumber("3", winningNumbers)
        }
    }
}
