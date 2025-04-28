package lotto

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class InputValidatorTest {

    @Test
    fun `should throw exception when purchase amount is not a multiple of 1000`() {
        assertThatThrownBy {InputValidator.validatePurchaseAmount(1500) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] The purchase amount must be divisible by 1,000")
    }
}
