package lotto.input

import lotto.InputView
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows

/**
 * @packageName    : lotto
 * @fileName       : InputTest
 * @author         : yong
 * @date           : 4/23/25
 * @description    :
 */
class MoneyInputTest {
    @Test
    fun `should return correct number of tickets when purchase amount is divisible by 1000 and positive`() {
        // given
        val amount: String = GOOD_AMOUNT_FOR_PURCHASING_TICKET

        // when
        val result = InputView.inputPurchaseAmount(amount)

        // then
        assertEquals(5, result)
    }

    @Test
    fun `should throw exception when purchase amount is not divisible by 1000`() {
        // given
        val amount: String = INVALID_AMOUNT_FOR_PURCHASING_TICKET

        // when & then
        assertThrows(IllegalArgumentException::class.java) {
            InputView.inputPurchaseAmount(amount)
        }
    }

    @Test
    fun `should throw exception when purchase amount is negative`() {
        // given
        val amount: String = NEGATIVE_AMOUNT

        // when & then
        assertThrows(IllegalArgumentException::class.java) {
            InputView.inputPurchaseAmount(amount)
        }
    }

    companion object {
        private const val GOOD_AMOUNT_FOR_PURCHASING_TICKET = "5000"
        private const val INVALID_AMOUNT_FOR_PURCHASING_TICKET = "4500"
        private const val NEGATIVE_AMOUNT = "-1000"
    }
}