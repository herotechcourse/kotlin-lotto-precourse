package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputParsingTest {
    @Test
    fun `returns int when input is a valid number`() {
        val result = parseInputToInt("1234")
        assertThat(result).isEqualTo(1234)
    }

    @Test
    fun `returns null when input is not a number`() {
        val result = parseInputToInt("abc")
        assertThat(result).isNull()
    }

    @Test
    fun `returns null when input is null`() {
        val result = parseInputToInt(null)
        assertThat(result).isNull()
    }
}