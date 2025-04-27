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

    @ParameterizedTest
    @MethodSource("validWinningNumbers")
    fun `valid winning numbers should not throw an exception`(numbers: List<Int>) {
        assertDoesNotThrow { purchaseAmountValidator.validateWinningNumbers(numbers) }
    }

    @ParameterizedTest
    @MethodSource("invalidWinningNumbers")
    fun `invalid winning numbers should throw an exception`(numbers: List<Int>) {
        assertThrows<IllegalArgumentException> {
            purchaseAmountValidator.validateWinningNumbers(numbers)
        }
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

        @JvmStatic
        fun validWinningNumbers(): List<List<Int>> = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(10, 20, 30, 40, 41, 45),
            listOf(7, 14, 21, 28, 35, 42)
        )

        @JvmStatic
        fun invalidWinningNumbers(): List<List<Int>> = listOf(
            listOf(1, 2, 3, 4, 5),
            listOf(1, 2, 3, 4, 5, 5),
            listOf(0, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 46),
            listOf(1, 2, 3, 4, 5, 100)
        )
    }
}