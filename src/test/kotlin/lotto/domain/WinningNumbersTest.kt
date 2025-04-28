package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class WinningNumbersTest {
    @Test
    fun `throws exception when fewer than six numbers provided`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5)

        // when

        // then
        assertThatThrownBy { WinningNumbers(numbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErrorMessages.INVALID_WINNING_NUMBERS_SIZE)
    }

    @Test
    fun `throws exception when more than six numbers provided`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7)

        // when

        // then
        assertThatThrownBy { WinningNumbers(numbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErrorMessages.INVALID_WINNING_NUMBERS_SIZE)
    }

    @Test
    fun `throws exception when numbers contain duplicates`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 5)

        // when

        // then
        assertThatThrownBy { WinningNumbers(numbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErrorMessages.INVALID_WINNING_NUMBERS_DUPLICATED)
    }

    @Test
    fun `throws exception when a number exceeds the maximum range`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 46)

        // when

        // then
        assertThatThrownBy { WinningNumbers(numbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErrorMessages.INVALID_NUMBERS_RANGE)
    }

    @Test
    fun `throws exception when a number is below the minimum range`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 0)

        // when

        // then
        assertThatThrownBy { WinningNumbers(numbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErrorMessages.INVALID_NUMBERS_RANGE)
    }

    @Test
    fun `initializes successfully with exactly six valid numbers`() {
        // given
        val numbers = listOf(1, 2, 3, 4, 5, 6)

        // when
        val winning = WinningNumbers(numbers)

        // then
        assertThat(winning.numbers).containsExactly(1, 2, 3, 4, 5, 6)
    }
}
