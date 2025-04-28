package lotto.inputTest

import lotto.util.Messages
import lotto.util.Validator
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class BonusNumberTest {
    private val winnerNumbers = listOf(1, 2, 3, 4, 5, 6)

    @Test
    fun `should return number when input is valid and not repeated in winner numbers`() {
        val result = Validator.validateBonusNumber("7", winnerNumbers)
        assertThat(result).isEqualTo(7)
    }

    @Test
    fun `should throw IllegalArgumentException when number is out of range`() {
        assertThatThrownBy { Validator.validateBonusNumber("48", winnerNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Messages.ERROR_OUT_OF_RANGE)
    }

    @Test
    fun `should throw IllegalArgumentException when is not a number`() {
        assertThatThrownBy { Validator.validateBonusNumber("lala", winnerNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Messages.ERROR_INVALID_NUMBER)
    }

    @Test
    fun `should throw IllegalArgumentException when number is already in winner numbers`() {
        assertThatThrownBy { Validator.validateBonusNumber("2", winnerNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Messages.ERROR_BONUS_IN_WINNER)
    }

    @Test
    fun `should throw IllegalArgumentException when there is more than one number`() {
        assertThatThrownBy { Validator.validateBonusNumber("8,9", winnerNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Messages.ERROR_INVALID_NUMBER)
    }
}