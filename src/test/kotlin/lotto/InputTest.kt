package lotto

import lotto.view.InputView
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class InputTest {
    @Test
    fun `valid purchase amount returns integer`() {
        val input = "5000"
        val result = InputView.validatePurchaseAmount(input)
        assertThat(result).isEqualTo(5000)
    }

    @Test
    fun `non-integer input throws exception`() {
        val input = "abc"
        assertThatThrownBy { InputView.validatePurchaseAmount(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `amount not multiple of 1000 throws exception`() {
        val input = "2500"
        assertThatThrownBy { InputView.validatePurchaseAmount(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `amount less than 1000 throws exception`() {
        val input = "500"
        assertThatThrownBy { InputView.validatePurchaseAmount(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }
}