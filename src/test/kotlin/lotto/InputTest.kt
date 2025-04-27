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

    @Test
    fun `valid winning numbers return list`() {
        val input = "1,2,3,4,5,6"
        val result = InputView.validateWinningNumbers(input)
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `winning numbers with duplicate throws exception`() {
        val input = "1,2,2,4,5,6"
        assertThatThrownBy { InputView.validateWinningNumbers(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `winning numbers out of range throws exception`() {
        val input = "0,2,3,4,5,6"
        assertThatThrownBy { InputView.validateWinningNumbers(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `winning numbers with non-integer throws exception`() {
        val input = "1,2,three,4,5,6"
        assertThatThrownBy { InputView.validateWinningNumbers(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `valid bonus number returns integer`() {
        val input = "7"
        val result = InputView.validateBonusNumber(input)
        assertThat(result).isEqualTo(7)
    }

    @Test
    fun `bonus number out of range throws exception`() {
        val input = "46"
        assertThatThrownBy { InputView.validateBonusNumber(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `non-integer bonus number throws exception`() {
        val input = "bonus"
        assertThatThrownBy { InputView.validateBonusNumber(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }
}