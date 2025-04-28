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
}
