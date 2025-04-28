import lotto.utils.Constant.AMOUNT_NOT_DIVISIBLE_ERROR_MESSAGE
import lotto.utils.Constant.INVALID_WINNING_NUMERIC_ERROR_MESSAGE
import lotto.utils.Constant.PURCHASE_AMOUNT_INPUT_ERROR_MESSAGE
import lotto.utils.Exceptions.validatePurchaseAmount
import lotto.utils.Exceptions.validateWinningNumbers
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class ExceptionsTest {
    @Test
    fun `throw an exception if purchase amount is not a number`() {
        assertThatThrownBy {
            validatePurchaseAmount("abc").getOrThrow()
        }
            .isInstanceOf(NumberFormatException::class.java)
            .hasMessageContaining(PURCHASE_AMOUNT_INPUT_ERROR_MESSAGE)
    }

    @Test
    fun `throw an exception if purchase amount is not divisible by LOTTO_COST`() {
        assertThatThrownBy {
            validatePurchaseAmount("1501").getOrThrow()
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(AMOUNT_NOT_DIVISIBLE_ERROR_MESSAGE)
    }

    @Test
    fun `throw an exception if winning numbers contain non-numeric values`() {
        assertThatThrownBy {
            validateWinningNumbers(listOf("1", "2", "A", "4", "5", "6")).getOrThrow()
        }
            .isInstanceOf(NumberFormatException::class.java)
            .hasMessageContaining(INVALID_WINNING_NUMERIC_ERROR_MESSAGE)
    }

}
