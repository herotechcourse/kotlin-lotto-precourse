package lotto.validator

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class WinningNumbersValidatorTest {

    @Test
    fun `throws exception when winning numbers size is not 6`() {
        val invalidNumbers = listOf("1", "2", "3", "4", "5")

        val exception = assertThrows(IllegalArgumentException::class.java) {
            WinningNumbersValidator.validate(invalidNumbers)
        }
    }

    @Test
    fun `throws exception when winning numbers are not unique`() {
        val invalidNumbers = listOf("1", "2", "3", "4", "5", "5")

        val exception = assertThrows(IllegalArgumentException::class.java) {
            WinningNumbersValidator.validate(invalidNumbers)
        }
        assertEquals("[ERROR] Winning numbers must be unique.", exception.message)
    }

    @Test
    fun `throws exception when winning numbers are not numeric`() {
        val invalidNumbers = listOf("1", "2", "3", "4", "5", "A")

        val exception = assertThrows(IllegalArgumentException::class.java) {
            WinningNumbersValidator.validate(invalidNumbers)
        }
        assertEquals("[ERROR] Winning numbers must be numeric values.", exception.message)
    }

    @Test
    fun `throws exception when winning numbers are out of range`() {
        val invalidNumbers = listOf("1", "2", "3", "4", "5", "46")

        val exception = assertThrows(IllegalArgumentException::class.java) {
            WinningNumbersValidator.validate(invalidNumbers)
        }
        assertEquals("[ERROR] Winning numbers must be between 1 and 45.", exception.message)
    }


    @Test
    fun `validates successfully with correct input`() {
        val winningNumbers = listOf("1", "2", "3", "4", "5", "6")

        assertDoesNotThrow {
            WinningNumbersValidator.validate(winningNumbers)
        }
    }

}