package lotto

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputParserTest {

    @Test
    fun `should throw exception when input is not a valid integer`() {
        assertThatThrownBy { InputParser.parseToInt("1000a") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Please enter a valid number.")
    }

    @Test
    fun `should parse valid input into list of numbers`() {
        val input = "1,2,3,4,5,6"
        val numbers = InputParser.parseToNumbers(input)
        assertThat(numbers).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `should parse input with spaces into list of numbers`() {
        val input = "1,   2 , 3 ,4 ,5 , 6"
        val numbers = InputParser.parseToNumbers(input)
        assertThat(numbers).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `should throw exception when input is not all numbers`() {
        assertThatThrownBy { InputParser.parseToNumbers("1,2,a,4,5,6") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Please enter a valid number.")
    }
}
