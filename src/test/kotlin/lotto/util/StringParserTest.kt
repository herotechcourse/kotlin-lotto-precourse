package lotto.util

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringParserTest {

    @Test
    fun `should parse string to int`() {
        // given
        val input = "30"
        // when
        val result = StringParser.parseToInt(input)
        // then
        assertThat(result).isEqualTo(30)
    }

    @ParameterizedTest
    @ValueSource(strings = ["o", "l", " "])
    fun `throw exception when the input is not a number`(input: String) {
        assertThatThrownBy { StringParser.parseToInt(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Input value must be a number.")
    }

    @Test
    fun `should parse string by delimiter`() {
        // given
        val input = "1,2,3,4,5,6"
        val delimiter = ","
        // when
        val result = StringParser.parseByDelimiter(input, delimiter)
        // then
        org.junit.jupiter.api.assertAll(
            { assertThat(result).hasSize(6) },
            { assertThat(result).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6) }
        )
    }

    @Test
    fun `throw exception when the input contains sth not comma and number`() {
        //given
        val input = "1.2.3.4.5.6"
        val delimiter = ","
        //when & then
        assertThatThrownBy { StringParser.parseByDelimiter(input, delimiter) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Please enter only numbers and commas.")
    }
}
