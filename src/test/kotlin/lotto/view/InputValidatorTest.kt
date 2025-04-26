package lotto.view

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["dss", "4jd", "hello", "#$"])
    fun `throw when input is not a number`(input: String) {
        Assertions.assertThatIllegalArgumentException().isThrownBy { InputValidator.validatePurchaseAmount(input) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["  ", ""])
    fun `throw when input is blank`(input: String) {
        Assertions.assertThatIllegalArgumentException().isThrownBy { InputValidator.validateBlank(input) }
    }
}