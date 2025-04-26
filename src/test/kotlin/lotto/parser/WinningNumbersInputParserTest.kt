package lotto.parser

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumbersInputParserTest {

    private val parser = WinningNumbersInputParser()

    @Test
    fun `parses valid input into list of integers`() {
        // given
        val input = "1,2,3,4,5,6"

        // when
        val numbers = parser.parse(input)

        // then
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `throws exception with message when input does not contain exactly required size`() {
        // given
        val input = "1,2,3,4,5"

        // when
        val exception = assertThrows<IllegalArgumentException> {
            parser.parse(input)
        }

        // then
        assertThat(exception.message).isEqualTo(WinningNumbersInputParser.INVALID_WINNING_NUMBERS_SIZE)
    }

    @Test
    fun `throws exception with message when input contains non-integer value`() {
        // given
        val input = "1,2,3,five,5,6"

        // when
        val exception = assertThrows<IllegalArgumentException> {
            parser.parse(input)
        }

        // then
        assertThat(exception.message).isEqualTo(WinningNumbersInputParser.INVALID_NUMBER_FORMAT)
    }

    @Test
    fun `throws exception with message when input is empty`() {
        // given
        val input = ""

        // when
        val exception = assertThrows<IllegalArgumentException> {
            parser.parse(input)
        }

        // then
        assertThat(exception.message).isEqualTo(WinningNumbersInputParser.INVALID_WINNING_NUMBERS_SIZE)
    }
}
