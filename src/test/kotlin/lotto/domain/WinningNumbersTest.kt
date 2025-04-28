package lotto.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class WinningNumbersTest {
    @Test
    fun `valid winning numbers and bonus`() {
        val wn = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)
        assertThat(wn.mainNumbers()).containsExactly(1, 2, 3, 4, 5, 6)
        assertThat(wn.bonusNumber()).isEqualTo(7)
    }

    @Test
    fun `duplicate winning numbers throws exception`() {
        assertThatThrownBy {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 5), 6)
        }.hasMessage("[ERROR] Winning numbers must contain exactly 6 unique numbers.")
    }

    @Test
    fun `winning numbers out of range throws exception`() {
        assertThatThrownBy {
            WinningNumbers(listOf(0, 2, 3, 4, 5, 6), 7)
        }.hasMessage("[ERROR] Winning numbers must be between 1 and 45.")
    }

    @Test
    fun `bonus out of range throws exception`() {
        assertThatThrownBy {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 0)
        }.hasMessage("[ERROR] Bonus number must be between 1 and 45.")
    }

    @Test
    fun `bonus duplicates main numbers throws exception`() {
        assertThatThrownBy {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 6)
        }.hasMessage("[ERROR] Bonus number must not duplicate winning numbers.")
    }
}
