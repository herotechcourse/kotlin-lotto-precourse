package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class WinningNumbersTest {
    @Test
    fun `creates winning numbers with valid inputs`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val winningNumbers = WinningNumbers(numbers, bonusNumber)

        assertThat(winningNumbers.numbers).containsExactly(1, 2, 3, 4, 5, 6)
        assertThat(winningNumbers.bonusNumber).isEqualTo(7)
    }
    
    @Test
    fun `throws an exception when bonus number is in winning numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 3

        assertThrows<IllegalArgumentException> {
            WinningNumbers(numbers, bonusNumber)
        }
    }

    @Test
    fun `creates correct bonus bitmask`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val winningNumbers = WinningNumbers(numbers, bonusNumber)

        val expectedBonusBitmask = 1L shl 7
        assertThat(winningNumbers.bonusBitmask).isEqualTo(expectedBonusBitmask)
    }

    @Test
    fun `inherits properties from Lotto class`() {
        val numbers = listOf(6, 5, 4, 3, 2, 1)
        val bonusNumber = 7

        val winningNumbers = WinningNumbers(numbers, bonusNumber)

        assertThat(winningNumbers.numbers).containsExactly(1, 2, 3, 4, 5, 6)

        val expectedBitmask = (1L shl 1) or (1L shl 2) or (1L shl 3) or (1L shl 4) or (1L shl 5) or (1L shl 6)
        assertThat(winningNumbers.bitmask).isEqualTo(expectedBitmask)
    }
}