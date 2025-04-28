package lotto.validation

import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class WinningNumbersValidatorTest {
    @Test
    fun `throw exception when the input is empty`() {
        val input = ""

        assertThatThrownBy { WinningNumbersValidator.validate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageStartingWith("[ERROR]")
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "1, 2", "1, 2, 3", "1, 2, 3, 4", "1, 2, 3, 4, 5"])
    fun `throw exception when the input consist of 6 numbers`(input: String) {
        assertThatThrownBy { WinningNumbersValidator.validate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageStartingWith("[ERROR]")
    }

    @ParameterizedTest
    @ValueSource(strings = ["one", "10$", "one$", "-"])
    fun `throw exception when the input is not number`(input: String) {
        assertThatThrownBy { WinningNumbersValidator.validate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageStartingWith("[ERROR]")
    }

    @ParameterizedTest
    @ValueSource(strings = ["1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 6", "1, 5, 7, 10, 13, 15"])
    fun `pass validation when the input consists of 6 number from 1 to 45`(input: String) {
        assertThatCode { WinningNumbersValidator.validate(input) }
            .doesNotThrowAnyException()
    }
}
