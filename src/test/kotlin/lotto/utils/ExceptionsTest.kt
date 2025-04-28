import lotto.utils.Constant.AMOUNT_NOT_DIVISIBLE_ERROR_MESSAGE
import lotto.utils.Constant.PURCHASE_AMOUNT_INPUT_ERROR_MESSAGE
import lotto.utils.Exceptions.validatePurchaseAmount
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
    fun `throw an exception if purchase amount is not divisible by 1,000`() {
        assertThatThrownBy {
            validatePurchaseAmount("1501").getOrThrow()
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(AMOUNT_NOT_DIVISIBLE_ERROR_MESSAGE)
    }

}
