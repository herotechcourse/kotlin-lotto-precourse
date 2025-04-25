import lotto.domain.InputValidator
import lotto.messages.PurchaseErrorMessage
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ValidationTest {

    private val validator = InputValidator()

    @Test
    fun `should return valid amount when input is correct`() {
        val input = "3000"
        val result = validator.validatePurchaseInput(input)
        assertThat(result).isEqualTo(3000)
    }

    @Test
    fun `should throw when input is not a number`() {
        val input = "abc"
        assertThatThrownBy { validator.validatePurchaseInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(PurchaseErrorMessage.NOT_A_NUMBER.message)
    }

    @Test
    fun `should throw when input is negative`() {
        val input = "-1000"
        assertThatThrownBy { validator.validatePurchaseInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(PurchaseErrorMessage.NEGATIVE_NUMBER.message)
    }

    @Test
    fun `should throw when input is less than 1000`() {
        val input = "500"
        assertThatThrownBy { validator.validatePurchaseInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(PurchaseErrorMessage.LESS_THAN_MINIMUM.message)
    }

    @Test
    fun `should throw when input is not a multiple of 1000`() {
        val input = "1200"
        assertThatThrownBy { validator.validatePurchaseInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(PurchaseErrorMessage.NOT_A_MULTIPLE_OF_1000.message)
    }
}
