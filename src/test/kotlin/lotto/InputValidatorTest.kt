package lotto

import lotto.util.InputValidator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidatorTest {

    @Test
    fun `parseAmount should return valid amount when input is correct`() {
        val input = "2000"
        val result = InputValidator.parseAmount(input)
        assertEquals(2000, result, "Amount should be parsed correctly")
    }

    @Test
    fun `parseAmount should throw exception when input is not a valid number`() {
        val input = "abcd"
        val exception = assertThrows<IllegalArgumentException> {
            InputValidator.parseAmount(input)
        }
        assertEquals("[ERROR] Amount must be a number.", exception.message)
    }

    @Test
    fun `parseAmount should throw exception when amount is not divisible by 1000`() {
        val input = "1500"
        val exception = assertThrows<IllegalArgumentException> {
            InputValidator.parseAmount(input)
        }
        assertEquals("[ERROR] Amount must be divisible by 1000.", exception.message)
    }

    @Test
    fun `parseWinningNumbers should return valid list of numbers when input is correct`() {
        val input = "1, 2, 3, 4, 5, 6"
        val result = InputValidator.parseWinningNumbers(input)
        assertEquals(listOf(1, 2, 3, 4, 5, 6), result, "Winning numbers should be parsed correctly")
    }

    @Test
    fun `parseWinningNumbers should throw exception when input contains invalid number`() {
        val input = "1, 2, 3, 4, 5, 46"
        val exception = assertThrows<IllegalArgumentException> {
            InputValidator.parseWinningNumbers(input)
        }
        assertEquals("[ERROR] Winning numbers must be 6 numbers between 1 and 45.", exception.message)
    }

    @Test
    fun `parseBonusNumber should return valid number when input is correct`() {
        val input = "7"
        val result = InputValidator.parseBonusNumber(input)
        assertEquals(7, result, "Bonus number should be parsed correctly")
    }

    @Test
    fun `parseBonusNumber should throw exception when input is not within valid range`() {
        val input = "46"
        val exception = assertThrows<IllegalArgumentException> {
            InputValidator.parseBonusNumber(input)
        }
        assertEquals("[ERROR] Bonus number must be between 1 and 45.", exception.message)
    }

    @Test
    fun `parseBonusNumber should throw exception when input is not a valid number`() {
        val input = "abcd"
        val exception = assertThrows<IllegalArgumentException> {
            InputValidator.parseBonusNumber(input)
        }
        assertEquals("[ERROR] Bonus number must be a valid integer.", exception.message)
    }
}
