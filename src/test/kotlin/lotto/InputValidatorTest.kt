package lotto

import lotto.util.InputValidator
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class InputValidatorTest {

    @Test
    fun `should throw exception when purchase amount is not a multiple of 1000`() {
        assertThatThrownBy { InputValidator.validatePurchaseAmount(1500) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] The purchase amount must be divisible by 1,000")
    }

    @Test
    fun `should throw exception when bonus number is out of range`() {
        assertThatThrownBy {
            InputValidator.validateBonusNumber(0, listOf(1, 2, 3, 4, 5, 6))
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Bonus number must be between 1 and 45.")

        assertThatThrownBy {
            InputValidator.validateBonusNumber(46, listOf(1, 2, 3, 4, 5, 6))
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Bonus number must be between 1 and 45.")
    }

    @Test
    fun `should throw exception when bonus number duplicates winning numbers`() {
        assertThatThrownBy {
            InputValidator.validateBonusNumber(3, listOf(1, 2, 3, 4, 5, 6))
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Bonus number must not duplicate winning numbers.")
    }
}
