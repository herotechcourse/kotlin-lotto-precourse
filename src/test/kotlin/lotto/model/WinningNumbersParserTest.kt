package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningNumbersParserTest {

    @Test
    fun `should parse comma-separated string into list of string`() {
        val input = "1,2,3,4,5,6"
        val result = WinningNumbersParser.parse(input)

        assertThat(result).containsExactly("1", "2", "3", "4", "5", "6")
    }

    @Test
    fun `should parse with spaces`() {
        val input = "1, 2, 3"
        val result = WinningNumbersParser.parse(input)

        assertThat(result).containsExactly("1", "2", "3")
    }
}