package lotto.domain.model

import lotto.config.Messages.BONUS_NUMBER_DUPLICATE
import lotto.config.Messages.WINNING_NUMBER_OVER_RANGE
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BonusNumberTest {

    @Test
    @DisplayName("Valid bonus number should create BonusNumber successfully")
    fun createBonusNumber_valid() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = BonusNumber(7, winningNumbers)

        assertEquals(7, bonusNumber.number)
    }

    @Test
    @DisplayName("Bonus number out of range should throw IllegalArgumentException with WINNING_NUMBER_OVER_RANGE")
    fun createBonusNumber_outOfRange() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        val exception = assertThrows(IllegalArgumentException::class.java) {
            BonusNumber(46, winningNumbers)
        }

        assertEquals(WINNING_NUMBER_OVER_RANGE, exception.message)
    }

    @Test
    @DisplayName("Bonus number duplicated with winning numbers should throw IllegalArgumentException with BONUS_NUMBER_DUPLICATE")
    fun createBonusNumber_duplicateWithWinningNumbers() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        val exception = assertThrows(IllegalArgumentException::class.java) {
            BonusNumber(5, winningNumbers)
        }

        assertEquals(BONUS_NUMBER_DUPLICATE, exception.message)
    }
}
