package lotto.validation

import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class WinningNumbersValidatorTest {
    @Test
    fun `throw exception when the input is empty`() {
        val input = listOf("")

        assertThatThrownBy { WinningNumbersValidator.validate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageStartingWith("[ERROR]")
    }

    @Test
    fun `throw exception when the input consist of 6 numbers`() {
        val input = listOf("1", "2", "3", "4", "5")

        assertThatThrownBy { WinningNumbersValidator.validate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageStartingWith("[ERROR]")
    }

    @Test
    fun `throw exception when the input is not number`() {
        val input = listOf("one")

        assertThatThrownBy { WinningNumbersValidator.validate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageStartingWith("[ERROR]")
    }

    @Test
    fun `pass validation when the input consists of 6 number from 1 to 45`() {
        val input = listOf("1", "2", "3", "4", "5", "40")

        assertThatCode { WinningNumbersValidator.validate(input) }
            .doesNotThrowAnyException()
    }
}
