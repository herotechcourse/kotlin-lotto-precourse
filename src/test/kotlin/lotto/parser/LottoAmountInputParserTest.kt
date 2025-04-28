package lotto.parser

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoAmountInputParserTest {

    private val parser = LottoAmountInputParser()

    @Test
    fun `parses valid integer string to Int`() {
        // given
        val input = "10000"

        // when
        val result = parser.parseToInt(input)

        // then
        assertThat(result).isEqualTo(10000)
    }

    @Test
    fun `throws exception with message when input is not an integer`() {
        // given
        val input = "abc"

        // when
        val exception = assertThrows<IllegalArgumentException> {
            parser.parseToInt(input)
        }

        // then
        assertThat(exception.message).isEqualTo(LottoAmountInputParser.INVALID_INPUT)
    }

    @Test
    fun `throws exception with message when input is empty`() {
        // given
        val input = ""

        // when
        val exception = assertThrows<IllegalArgumentException> {
            parser.parseToInt(input)
        }

        // then
        assertThat(exception.message).isEqualTo(LottoAmountInputParser.INVALID_INPUT)
    }
}
