package lotto.validation

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class BonusNumberValidatorTest {

    @Test
    fun `throw exception when the input is empty`() {
        val input = ""

        assertThatThrownBy { BonusNumberValidator.validate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageStartingWith("[ERROR]")
    }

    @Test
    fun `throw exception when the input is not number`() {
        val input = "six"

        assertThatThrownBy { BonusNumberValidator.validate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageStartingWith("[ERROR]")
    }

    @Test
    fun `throw exception when the input is not between 1 and 45`() {
        val input = "47"

        assertThatThrownBy { BonusNumberValidator.validate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageStartingWith("[ERROR]")
    }

    @Test
    fun `throw exception when the input consist of winning numbers`() {
        val bonusNumber = "6"
        val winningNumbers = listOf("1", "2", "3", "4", "5","6")

        assertThatThrownBy { BonusNumberValidator.validateDuplicateWithWinningNumbers(bonusNumber, winningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageStartingWith("[ERROR]")
    }

}
