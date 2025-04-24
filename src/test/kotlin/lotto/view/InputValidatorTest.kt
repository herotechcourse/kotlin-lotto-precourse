package lotto.view

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {
    @ParameterizedTest
    @DisplayName("[Exception] when input is not number, throw exception")
    @ValueSource(strings = ["dss","4jd","hello","#$"])
    fun `test number validation`(input: String) {
        Assertions.assertThatIllegalArgumentException().isThrownBy { InputValidator.parseAndValidateNumber(input) }
    }
}