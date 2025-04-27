package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class PurchaseAmountValidatorTest {

    private val purchaseAmountValidator = PurchaseAmountValidator()

    @ParameterizedTest
    @MethodSource("validPurchaseAmount")
    fun `valid car names should not throw an exception`(purchaseAmount: Int?) {
        assertDoesNotThrow { purchaseAmountValidator.validatePurchaseAmount(purchaseAmount) }
    }

    @ParameterizedTest
    @MethodSource("invalidPurchaseAmount")
    fun `invalid car names should throw an exception`(purchaseAmount: Int?) {
        val exception = assertThrows<IllegalArgumentException> {
            purchaseAmountValidator.validatePurchaseAmount(purchaseAmount)
        }

        assertThat(exception.message).isEqualTo("[ERROR] Invalid purchase amount. " +
                "Input must be greater than zero and divisible by 1,000")
    }

    companion object {
        @JvmStatic
        fun validPurchaseAmount(): List<Int?> = listOf(
            1000,
            2000,
            5000,
            10000
        )

        @JvmStatic
        fun invalidPurchaseAmount(): List<Int?> = listOf(
            null,
            0,
            -1000,
            999,
            1500,
            1234
        )
    }
}