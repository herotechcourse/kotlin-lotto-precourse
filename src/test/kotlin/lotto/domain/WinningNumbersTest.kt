package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersTest {

    @Test
    fun `throws exception when the winning numbers are less than 6`() {
        val input = listOf(1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> {
            WinningNumbers.from(input)
        }
    }

    @Test
    fun `throws exception when the winning numbers contain duplicates`() {
        val input = listOf(1, 2, 3, 4, 5, 5)
        assertThrows<IllegalArgumentException> {
            WinningNumbers.from(input)
        }
    }

    @Test
    fun `creates valid WinningNumbers with 6 unique numbers`() {
        val input = listOf(1, 2, 3, 4, 5, 6)
        val winningNumbers = WinningNumbers.from(input)
        assertThat(winningNumbers.getNumbers().map { it.number })
            .containsExactlyInAnyOrderElementsOf(input)
    }

    @Test
    fun `counts how many numbers match between winning numbers and a lotto ticket`() {
        val winning = WinningNumbers.from(listOf(1, 2, 3, 4, 5, 6))
        val ticket = Lotto.of(listOf(1, 2, 7, 8, 9, 10))

        val matchCount = winning.matchCount(ticket)

        assertThat(matchCount).isEqualTo(2)
    }

    @Test
    fun `checks if bonus number exists in winning numbers`() {
        val winning = WinningNumbers.from(listOf(10, 11, 12, 13, 14, 15))
        val bonus = LottoNumber(12)
        val notBonus = LottoNumber(30)

        assertThat(winning.contains(bonus)).isTrue()
        assertThat(winning.contains(notBonus)).isFalse()
    }
}