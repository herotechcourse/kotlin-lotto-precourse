package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy

class PurchaseValidatorTest {

    @Test
    fun `should return number when input is valid and a multiple of ticket price`() {
        val result = Validator.validatePurchaseAmount("5000")
        assertThat(result).isEqualTo(5000)
    }

    @Test
    fun `should throw IllegalArgumentException when input is not a number`() {
        assertThatThrownBy { Validator.validatePurchaseAmount("abc") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Messages.ERROR_INVALID_NUMBER)
    }

    @Test
    fun `should throw IllegalArgumentException when input is not an integer`() {
        assertThatThrownBy { Validator.validatePurchaseAmount("14000,5") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Messages.ERROR_INVALID_NUMBER)
    }

    @Test
    fun `should throw IllegalArgumentException when input is a negative number`() {
        assertThatThrownBy { Validator.validatePurchaseAmount("-3000") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Messages.ERROR_NEGATIVE_NUMBER)
    }

    @Test
    fun `should throw IllegalArgumentException when input is not a multiple of ticket price`() {
        assertThatThrownBy { Validator.validatePurchaseAmount("2500") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Messages.ERROR_NOT_THOUSANDS)
    }
}