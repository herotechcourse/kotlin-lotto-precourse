package lotto.validation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseAmountValidatorTest {
    @Test
    fun `throw exception when the input is empty`() {
        //given
        val input = ""

        // when & then
        assertThrows<IllegalArgumentException> {
            PurchaseAmountValidator.validate(input)
        }
    }

    @Test
    fun `throw exception when the amount is less than 1,000`() {
        //given
        val input = "900"

        // when & then
        assertThrows<IllegalArgumentException> {
            PurchaseAmountValidator.validate(input)
        }
    }

    @Test
    fun `throw exception when the amount is not divisible by 1,000`() {
        //given
        val input = "1300"

        // when & then
        assertThrows<IllegalArgumentException> {
            PurchaseAmountValidator.validate(input)
        }
    }

    @Test
    fun `throw exception when the input is not a valid number`() {
        //given
        val input = "threeThousandDollars"

        // when & then
        assertThrows<IllegalArgumentException> {
            PurchaseAmountValidator.validate(input)
        }
    }
}
