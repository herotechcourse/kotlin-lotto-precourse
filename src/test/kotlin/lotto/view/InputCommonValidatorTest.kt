package lotto.view

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class InputCommonValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["dss", "4jd", "hello", "#$"])
    fun `throw when input is not a number`(input: String) {
        Assertions.assertThatIllegalArgumentException().isThrownBy { InputValidator.parseAndValidateNumber(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["  ", ""])
    fun `throw when input is blank`(input: String) {
        Assertions.assertThatIllegalArgumentException().isThrownBy { InputValidator.validateBlank(input) }
    }

    @ParameterizedTest
    @EmptySource
    fun `throw when input is empty`(input: String) {
        Assertions.assertThatIllegalArgumentException().isThrownBy { InputValidator.validateBlank(input) }
    }
}