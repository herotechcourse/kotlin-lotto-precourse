package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class PurchaseAmountValidationTest {
    @Test
    fun `does not throw an exception for valid amount`() {
        validateAmount(1000) // if no exception, test passes
    }

    @Test
    fun `throws an exception when amount is zero or negative`() {
        val exception = assertThrows<IllegalArgumentException> {
            validateAmount(0)
        }
        assertThat(exception.message).isEqualTo("[ERROR] Amount must be positive.")
    }

    @Test
    fun `throws an exception when amount is not divisible by 1000`() {
        val exception = assertThrows<IllegalArgumentException> {
            validateAmount(1500)
        }
        assertThat(exception.message).isEqualTo("[ERROR] Amount must be divisible by 1,000.")
    }
}