package lotto.validation

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BonusNumberValidatorTest {
    @Test
    fun `throw exception when the input is empty`() {
        val input = ""

        assertThatThrownBy { BonusNumberValidator.validate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageStartingWith("[ERROR]")
    }

    @ParameterizedTest
    @ValueSource(strings = ["six", "seven", "a", "eight"])
    fun `throw exception when the input is not number`(input: String) {
        assertThatThrownBy { BonusNumberValidator.validate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageStartingWith("[ERROR]")
    }

    @ParameterizedTest
    @ValueSource(strings = ["46", "47", "50", "100", "101"])
    fun `throw exception when the input is not between 1 and 45`(input: String) {
        assertThatThrownBy { BonusNumberValidator.validate(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageStartingWith("[ERROR]")
    }

    @Test
    fun `throw exception when the input consist of winning numbers`() {
        val bonusNumber = "6"
        val winningNumbers = listOf("1", "2", "3", "4", "5", "6")

        assertThatThrownBy { BonusNumberValidator.validateDuplicateWithWinningNumbers(bonusNumber, winningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageStartingWith("[ERROR]")
    }
}
