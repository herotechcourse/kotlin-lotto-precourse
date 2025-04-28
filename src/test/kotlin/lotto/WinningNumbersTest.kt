package lotto

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningNumbersTest {

    @Test
    fun `creates winning numbers successfully`() {
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 7)
        assertThat(winningNumbers.getWinningNumbers()).containsExactly(1, 2, 3, 4, 5, 6)
        assertThat(winningNumbers.getBonusNumber()).isEqualTo(7)
    }

    @Test
    fun `throws an exception when winning numbers are not exactly six`() {
        assertThatThrownBy {
            WinningNumbers(listOf(1, 2, 3, 4, 5), 7)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `throws an exception when winning numbers contain duplicates`() {
        assertThatThrownBy {
            WinningNumbers(listOf(1, 2, 2, 4, 5, 6), 7)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `throws an exception when a winning number is out of range`() {
        assertThatThrownBy {
            WinningNumbers(listOf(0, 2, 3, 4, 5, 6), 7)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `throws an exception when bonus number is out of range`() {
        assertThatThrownBy {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 46)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `throws an exception when bonus number duplicates a winning number`() {
        assertThatThrownBy {
            WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 6)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }
}
