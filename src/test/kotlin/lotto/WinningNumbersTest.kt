package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class WinningNumbersTest {

    @Test
    fun `throws error if winning numbers size is not 6`() {
        assertThatThrownBy {
            WinningNumbers(listOf(1, 2, 3, 4, 5), 7)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("6 winning numbers")
    }

    @Test
    fun `throws error if winning numbers have duplicates`() {
        assertThatThrownBy {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 5), 7)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("unique")
    }

    @Test
    fun `throws error if bonus number is in winning numbers`() {
        assertThatThrownBy {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 6)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("not be among winning numbers")
    }

    @Test
    fun `throws error if winning numbers have number out of range`() {
        assertThatThrownBy {
            WinningNumbers(listOf(0, 2, 3, 4, 5, 6), 7)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("between 1 and 45")
    }

    @Test
    fun `throws error if bonus number is out of range`() {
        assertThatThrownBy {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 50)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("between 1 and 45")
    }

    @Test
    fun `countMatch correctly counts matched numbers`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)
        val ticket = Lotto(listOf(1, 2, 7, 8, 9, 10))

        val matchCount = winningNumbers.countMatch(ticket)
        assertThat(matchCount).isEqualTo(2)
    }

    @Test
    fun `isBonusMatch correctly detects bonus match`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)
        val ticketWithBonus = Lotto(listOf(7, 8, 9, 10, 11, 12))
        val ticketWithoutBonus = Lotto(listOf(1, 2, 3, 8, 9, 10))

        assertThat(winningNumbers.isBonusMatch(ticketWithBonus)).isTrue()
        assertThat(winningNumbers.isBonusMatch(ticketWithoutBonus)).isFalse()
    }
}
