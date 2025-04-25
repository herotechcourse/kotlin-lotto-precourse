package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy

class WinningNumbersTest {

    @Test
    fun `should return a list of Int when all numbers fulfill requirements`() {
        val result = Validator.validateWinningNumbers("1,  4, 7, 43, 44, 45")
        assertThat(result).isEqualTo(listOf(1, 4, 7, 43, 44, 45))
    }

    @Test
    fun `should throw IllegalArgumentException when input contains not only numbers`() {
        assertThatThrownBy { Validator.validateWinningNumbers("1, 2, 4, ab, 6, 7") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Messages.ERROR_INVALID_NUMBER)
    }

    @Test
    fun `should throw IllegalArgumentException when input contains not exactly 6 numbers`() {
        assertThatThrownBy { Validator.validateWinningNumbers("1, 2, 4, 6, 7") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Messages.ERROR_NOT_SIX_NUMBERS)
    }

    @Test
    fun `should throw IllegalArgumentException when input contains duplicates`() {
        assertThatThrownBy { Validator.validateWinningNumbers("1, 2, 4, 6, 7, 2") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Messages.ERROR_NOT_UNIQUE)
    }

    @Test
    fun `should throw IllegalArgumentException when input contains out of range`() {
        assertThatThrownBy { Validator.validateWinningNumbers("1, 2, 4, 48, 7, 3") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Messages.ERROR_OUT_OF_RANGE)
    }
}