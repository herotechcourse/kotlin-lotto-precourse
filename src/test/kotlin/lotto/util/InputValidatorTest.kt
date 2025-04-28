package lotto.view

import lotto.config.Messages
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class InputValidatorTest {

    @Test
    @DisplayName("Valid amount passes validation")
    fun validateAmount_valid() {
        InputValidator.validateAmount(5000)
    }

    @Test
    @DisplayName("Invalid amount not divisible by LOTTO_PRICE throws exception")
    fun validateAmount_notDivisible() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateAmount(1500)
        }
        assertEquals(Messages.INPUT_NOT_DIVIDABLE, exception.message)
    }

    @Test
    @DisplayName("Invalid amount not positive throws exception")
    fun validateAmount_notPositive() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateAmount(0)
        }
        assertEquals(Messages.NUMBER_NOT_POSITIVE, exception.message)
    }

    @Test
    @DisplayName("Valid winning numbers pass validation")
    fun validateWinningNumbers_valid() {
        InputValidator.validateWinningNumbers(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    @DisplayName("Duplicate winning numbers throw exception")
    fun validateWinningNumbers_duplicates() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateWinningNumbers(listOf(1, 2, 2, 3, 4, 5))
        }
        assertEquals(Messages.WINNING_NUMBER_DUPLICATE, exception.message)
    }

    @Test
    @DisplayName("Winning numbers out of range throw exception")
    fun validateWinningNumbers_outOfRange() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateWinningNumbers(listOf(1, 2, 3, 4, 5, 46))
        }
        assertEquals(Messages.WINNING_NUMBER_OVER_RANGE, exception.message)
    }

    @Test
    @DisplayName("Winning numbers size not 6 throws exception")
    fun validateWinningNumbers_wrongSize() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateWinningNumbers(listOf(1, 2, 3, 4, 5))
        }
        assertEquals(Messages.WINNING_NUMBER_SIZE_NOT_SIX, exception.message)
    }

    @Test
    @DisplayName("Valid bonus number passes validation")
    fun validateBonusNumber_valid() {
        InputValidator.validateBonusNumber(7, listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    @DisplayName("Bonus number duplicated with winning numbers throws exception")
    fun validateBonusNumber_duplicate() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateBonusNumber(5, listOf(1, 2, 3, 4, 5, 6))
        }
        assertEquals(Messages.BONUS_NUMBER_DUPLICATE, exception.message)
    }

    @Test
    @DisplayName("Bonus number out of range throws exception")
    fun validateBonusNumber_outOfRange() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateBonusNumber(50, listOf(1, 2, 3, 4, 5, 6))
        }
        assertEquals(Messages.WINNING_NUMBER_OVER_RANGE, exception.message)
    }
}
