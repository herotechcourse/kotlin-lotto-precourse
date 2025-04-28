package lotto.validation

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PurchaseAmountValidatorTest {
    @Test
    fun `throw exception when the input is empty`() {
        val input = ""

        assertThatThrownBy { PurchaseAmountValidator.validate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageStartingWith("[ERROR]")
        }


    @ParameterizedTest
    @ValueSource(strings = ["46", "47", "50", "100", "300", "350"])
    fun `throw exception when the amount is less than 1,000`(input: String) {
        assertThrows<IllegalArgumentException> {
            PurchaseAmountValidator.validate(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1300", "1001", "1023", "1000345", "11233", "44444"])
    fun `throw exception when the amount is not divisible by 1,000`(input: String) {
        assertThrows<IllegalArgumentException> {
            PurchaseAmountValidator.validate(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["threeThousandDollars", "dollars", "a", "b"])
    fun `throw exception when the input is not a valid number`(input: String) {
        assertThrows<IllegalArgumentException> {
            PurchaseAmountValidator.validate(input)
        }
    }
}
