package lotto.domain.model

import lotto.config.Messages.WINNING_NUMBER_DUPLICATE
import lotto.config.Messages.WINNING_NUMBER_OVER_RANGE
import lotto.config.Messages.WINNING_NUMBER_SIZE_NOT_SIX
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class WinningNumberTest {

    @Test
    @DisplayName("Creating WinningNumber with valid numbers should succeed")
    fun createWinningNumber_valid() {
        val winningNumber = WinningNumber(listOf(1, 2, 3, 4, 5, 6))

        assertEquals(listOf(1, 2, 3, 4, 5, 6), winningNumber.numbers)
    }

    @Test
    @DisplayName("Creating WinningNumber with duplicate numbers should throw IllegalArgumentException with WINNING_NUMBER_DUPLICATE")
    fun createWinningNumber_withDuplicates() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            WinningNumber(listOf(1, 2, 3, 3, 5, 6))
        }

        assertEquals(WINNING_NUMBER_DUPLICATE, exception.message)
    }

    @Test
    @DisplayName("Creating WinningNumber with a number out of range should throw IllegalArgumentException with WINNING_NUMBER_OVER_RANGE")
    fun createWinningNumber_withOutOfRange() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            WinningNumber(listOf(0, 2, 3, 4, 5, 6))
        }

        assertEquals(WINNING_NUMBER_OVER_RANGE, exception.message)
    }

    @Test
    @DisplayName("Creating WinningNumber with size not equal to 6 should throw IllegalArgumentException with WINNING_NUMBER_SIZE_NOT_SIX")
    fun createWinningNumber_withInvalidSize() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            WinningNumber(listOf(1, 2, 3, 4, 5)) // 5개
        }

        assertEquals(WINNING_NUMBER_SIZE_NOT_SIX, exception.message)
    }
}
