package lotto.view

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputValidatorTest {

    @Test
    fun `valid amount input returns parsed Int`() {
        val input = "3000"
        val result = InputValidator.validateAmount(input)
        assertThat(result).isEqualTo(3000)
    }

    @Test
    fun `invalid amount input throws exception`() {
        val input = "invalid"
        assertThatThrownBy { InputValidator.validateAmount(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `valid winning numbers input returns list of Int`() {
        val input = "1,2,3,4,5,6"
        val result = InputValidator.validateWinningNumbers(input)
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `invalid winning numbers input throws exception`() {
        val input = "1,2,a,4,5,6"
        assertThatThrownBy { InputValidator.validateWinningNumbers(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `valid bonus number input returns parsed Int`() {
        val input = "7"
        val result = InputValidator.validateBonusNumber(input)
        assertThat(result).isEqualTo(7)
    }

    @Test
    fun `invalid bonus number input throws exception`() {
        val input = "luck"
        assertThatThrownBy { InputValidator.validateBonusNumber(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
