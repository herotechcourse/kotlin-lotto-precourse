package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class WinningNumbersTest {

    @Test
    fun `creates WinningNumbers with valid numbers`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val bonus = 7
        val wn = WinningNumbers(numbers, bonus)

        assertThat(wn.getWinningNumbers()).containsExactly(1, 2, 3, 4, 5, 6)
        assertThat(wn.getBonusNumber()).isEqualTo(7)
    }

    @Test
    fun `throws exception when count is not 6`() {
        assertThatThrownBy { WinningNumbers(listOf(1, 2, 3, 4, 5), 6) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `throws exception when numbers are not unique`() {
        assertThatThrownBy { WinningNumbers(listOf(1, 2, 2, 3, 4, 5), 6) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `throws exception when a winning number is out of range`() {
        assertThatThrownBy { WinningNumbers(listOf(0, 2, 3, 4, 5, 6), 7) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `throws exception when bonus number is out of range`() {
        assertThatThrownBy { WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 46) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `throws exception when bonus number duplicates a winning number`() {
        assertThatThrownBy { WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 6) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }
}