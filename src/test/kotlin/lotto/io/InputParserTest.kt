package lotto.io

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputParserTest {

    @Test
    fun `parsePurchaseAmount returns correct purchase count when input is valid`() {
        val input = "3000"
        val result = InputParser.parsePurchaseAmount(input)
        assertEquals(3, result)
    }

    @Test
    fun `parsePurchaseAmount throws exception when input is blank`() {
        assertThrows<IllegalArgumentException> {
            InputParser.parsePurchaseAmount("")
        }
    }

    @Test
    fun `parsePurchaseAmount throws exception when input is not divisible by 1000`() {
        assertThrows<IllegalArgumentException> {
            InputParser.parsePurchaseAmount("2500")
        }
    }

    @Test
    fun `parseWinningNumbers returns list of numbers when input is valid`() {
        val input = "1,2,3,4,5,6"
        val result = InputParser.parseWinningNumbers(input)
        assertEquals(listOf(1, 2, 3, 4, 5, 6), result)
    }

    @Test
    fun `parseWinningNumbers throws exception when input has duplicates`() {
        val input = "1,2,3,4,5,5"
        assertThrows<IllegalArgumentException> {
            InputParser.parseWinningNumbers(input)
        }
    }

    @Test
    fun `parseWinningNumbers throws exception when input size is not 6`() {
        val input = "1,2,3,4,5"
        assertThrows<IllegalArgumentException> {
            InputParser.parseWinningNumbers(input)
        }
    }

    @Test
    fun `parseBonusNumber returns bonus number when input is valid`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val input = "7"
        val result = InputParser.parseBonusNumber(input, numbers)
        assertEquals(7, result)
    }

    @Test
    fun `parseBonusNumber throws exception when bonus number is in winning numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val input = "6"
        assertThrows<IllegalArgumentException> {
            InputParser.parseBonusNumber(input, numbers)
        }
    }

    @Test
    fun `parseBonusNumber throws exception when bonus number is out of range`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val input = "50"
        assertThrows<IllegalArgumentException> {
            InputParser.parseBonusNumber(input, numbers)
        }
    }
}