package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class WinningNumbersTest {

    @Test
    fun `creates WinningNumbers with valid numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val bonus = 7
        val wn = WinningNumbers.of(numbers, bonus)

        assertThat(wn.getWinningNumbers()).containsExactly(1, 2, 3, 4, 5, 6)
        assertThat(wn.getBonusNumber()).isEqualTo(7)
    }

    @Test
    fun `throws exception when count is not 6`() {
        assertThatThrownBy { WinningNumbers.parse("1,2,3,4,5", "7") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Winning numbers must contain exactly 6 numbers.")
    }

    @Test
    fun `throws exception when numbers are not unique`() {
        assertThatThrownBy { WinningNumbers.parse("1,2,2,3,4,5", "7") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Winning numbers must be unique.")
    }

    @Test
    fun `throws exception when a winning number is out of range`() {
        assertThatThrownBy { WinningNumbers.parse("0,2,3,4,5,6", "7") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Winning numbers must be between 1 and 45.")
    }

    @Test
    fun `throws exception when bonus number is non-numeric`() {
        assertThatThrownBy { WinningNumbers.parse("1,2,3,4,5,6", "x") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Bonus number must be numeric.")
    }

    @Test
    fun `throws exception when bonus number is out of range`() {
        assertThatThrownBy { WinningNumbers.parse("1,2,3,4,5,6", "46") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Bonus number must be between 1 and 45.")
    }

    @Test
    fun `throws exception when bonus number duplicates a winning number`() {
        assertThatThrownBy { WinningNumbers.parse("1,2,3,4,5,6", "6") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Bonus number must not duplicate winning numbers.")
    }
}