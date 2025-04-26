package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersTest {
    @Test
    fun `throws an exception when winning numbers are not exactly 6`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(1, 2, 3, 4, 5), 7)
        }
    }

    @Test
    fun `throws an exception when winning numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 5), 7)
        }
    }

    @Test
    fun `throws an exception when winning numbers are out of range`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 46), 7)
        }
    }

    @Test
    fun `throws an exception when bonus number is out of range`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 46)
        }
    }

    @Test
    fun `throws an exception when bonus number is included in winning numbers`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 6)
        }
    }

    @Test
    fun `returns correct rank for 6 matches`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        
        assertThat(winningNumbers.match(lotto)).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `returns correct rank for 5 matches with bonus`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 7))
        
        assertThat(winningNumbers.match(lotto)).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `returns correct rank for 5 matches without bonus`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)
        val lotto = Lotto(listOf(1, 2, 3, 4, 5, 8))
        
        assertThat(winningNumbers.match(lotto)).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `returns correct rank for 4 matches`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)
        val lotto = Lotto(listOf(1, 2, 3, 4, 8, 9))
        
        assertThat(winningNumbers.match(lotto)).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `returns correct rank for 3 matches`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)
        val lotto = Lotto(listOf(1, 2, 3, 8, 9, 10))
        
        assertThat(winningNumbers.match(lotto)).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `returns NONE rank for less than 3 matches`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)
        val lotto = Lotto(listOf(1, 2, 8, 9, 10, 11))
        
        assertThat(winningNumbers.match(lotto)).isEqualTo(Rank.NONE)
    }
}
