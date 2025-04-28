package lotto.ui

import lotto.util.Constants
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class InputParserTest {
    @Test
    fun `parseWinningNumbers should return valid numbers when input is correct`() {
        val input = "1, 2, 3, 4, 5, 6"
        val winningNumbers = InputParser.parseWinningNumbers(input)

        assertThat(winningNumbers).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `parseWinningNumbers should throw exception when input contains non-numeric value`() {
        val input = "1, 2, 3, 4, a, 6"

        assertThatThrownBy { InputParser.parseWinningNumbers(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Constants.ERROR_INVALID_WINNING_NUMBER)
    }
}