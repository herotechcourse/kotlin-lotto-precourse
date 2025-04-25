package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class WinningNumberTest {

    @Test
    fun `throws exception when there are not exactly 6 winning numbers`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5)

        // when & then
        assertThatThrownBy { WinningNumber(numbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Winning numbers must consist of exactly 6 numbers.")
    }

    @Test
    fun `throws exception when there are duplicate numbers`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 5)

        assertThatThrownBy { WinningNumber(numbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Winning numbers must be unique")
    }

    @Test
    fun `throws exception when numbers are out of range`() {
        // given
        val numbers = listOf(0, 2, 3, 4, 5, 46)

        // when & then
        assertThatThrownBy { WinningNumber(numbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Winning numbers must be between 1 and 45")
    }
}
