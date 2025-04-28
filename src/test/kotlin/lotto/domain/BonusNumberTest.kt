package lotto.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class BonusNumberTest {
    @Test
    fun `throws exception when a number exceeds the maximum range`() {
        // given
        val number = 46

        // when

        // then
        assertThatThrownBy { BonusNumber(number) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErrorMessages.INVALID_NUMBERS_RANGE)
    }

    @Test
    fun `throws exception when a number is below the minimum range`() {
        // given
        val number = 0

        // when

        // then
        assertThatThrownBy { BonusNumber(number) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErrorMessages.INVALID_NUMBERS_RANGE)
    }

    @Test
    fun `throws exception when a number contain duplicates`() {
        // given
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        val number = 6

        // when

        // then
        assertThatThrownBy { BonusNumber(number).requireNotDuplicated(winningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(ErrorMessages.INVALID_BONUS_NUMBER_DUPLICATED)
    }

    @Test
    fun `does not throw when bonus number is not in winning numbers`() {
        // given
        val winningNumbers = WinningNumbers(listOf(1, 2, 3, 4, 5, 6))
        val number = 7

        // when

        // then
        assertThatCode {
            BonusNumber(number).apply {
                requireNotDuplicated(winningNumbers)
            }
        }.doesNotThrowAnyException()
    }
}
