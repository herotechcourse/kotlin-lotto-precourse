package lotto.domain

import lotto.Lotto
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersTest {

    @Test
    fun `fails if there are fewer than six winning numbers`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(1, 2, 3, 4, 5), bonusNumber = 7)
        }
    }

    @Test
    fun `fails if winning numbers contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 5), bonusNumber = 7)
        }
    }

    @Test
    fun `fails if bonus number is part of winning numbers`() {
        assertThrows<IllegalArgumentException> {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 6), bonusNumber = 6)
        }
    }

    @Test
    fun `returns correct match count for given ticket`() {
        val winning = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), bonusNumber = 7)
        val ticket = Lotto(listOf(1, 2, 7, 8, 9, 10))

        Assertions.assertThat(winning.countMatches(ticket)).isEqualTo(2)
    }

    @Test
    fun `detects bonus number correctly when present in ticket`() {
        val winning = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), bonusNumber = 10)
        val ticket = Lotto(listOf(1, 2, 3, 10, 11, 12))

        Assertions.assertThat(winning.isBonusMatch(ticket)).isTrue()
    }

    @Test
    fun `detects bonus number correctly when absent from ticket`() {
        val winning = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), bonusNumber = 45)
        val ticket = Lotto(listOf(7, 8, 9, 10, 11, 12))

        Assertions.assertThat(winning.isBonusMatch(ticket)).isFalse()
    }
}