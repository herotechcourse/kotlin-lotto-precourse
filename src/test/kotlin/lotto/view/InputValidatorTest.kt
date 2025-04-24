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
        Assertions.assertThatIllegalArgumentException().isThrownBy { InputValidator.validatePurchaseAmount(input) }
    }

    @ParameterizedTest
    @DisplayName("[Exception] when purchase amount input exceed maximum limit, throw exception")
    @ValueSource(strings = ["150000","500000","100001"])
    fun `test purchase amount range`(input: String) {
        Assertions.assertThatIllegalArgumentException().isThrownBy { InputValidator.validatePurchaseAmount(input) }
    }

    @ParameterizedTest
    @DisplayName("[Exception] throw when purchase amount is not a valid unit")
    @ValueSource(strings = ["10800","5500","3115"])
    fun `test purchase amount unit`(input: String) {
        Assertions.assertThatIllegalArgumentException().isThrownBy { InputValidator.validatePurchaseAmount(input) }
    }
}