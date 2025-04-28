package lotto

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class InputParserTest {

    @Test
    fun `should throw exception when input is not a valid integer`() {
        assertThatThrownBy { InputParser.parseToInt("1000a") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Please enter a valid number.")
    }
}
