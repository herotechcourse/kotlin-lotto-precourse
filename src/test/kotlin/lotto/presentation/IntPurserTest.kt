package lotto.presentation

import lotto.presentation.ErrorMessages.INVALID_NUMBER
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class IntPurserTest {
    @Test
    fun `throws exception when input contains multiple numbers`() {
        // given
        val rawInput = "1 2"

        // when

        // then
        assertThatThrownBy { IntParser.parseSingle(rawInput) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(INVALID_NUMBER)
    }

    @Test
    fun `throws exception when input is non-numeric`() {
        // given
        val rawInput = "kdozlo"

        // when

        // then
        assertThatThrownBy { IntParser.parseSingle(rawInput) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(INVALID_NUMBER)
    }

    @Test
    fun `parses and returns integer when input is a single valid number`() {
        // given
        val rawInput = "8"

        // when
        val result = IntParser.parseSingle(rawInput)

        // then
        assertThat(result).isEqualTo(8)
    }
}
