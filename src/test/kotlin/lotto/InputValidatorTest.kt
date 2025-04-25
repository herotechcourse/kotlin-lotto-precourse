package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {

    private val validator = InputValidator()

    @Test
    fun `validatePurchaseAmount should return amount when valid`() {
        val result = validator.validatePurchaseAmount("5000")
        assertThat(result).isEqualTo(5000)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "abc", "123.45", "123,45", "@$.!:;"])
    fun `validatePurchaseAmount should throw exception when not a number`(input: String) {
        assertThatThrownBy { validator.validatePurchaseAmount(input) }
            .isInstanceOf(ValidationException::class.java)
            .hasMessage("The purchase amount must be a number.")
    }

    @Test
    fun `validatePurchaseAmount should throw exception when amount is zero`() {
        assertThatThrownBy { validator.validatePurchaseAmount("0") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("The purchase amount must be positive.")
    }

    @Test
    fun `validatePurchaseAmount should throw exception when amount not divisible by 1000`() {
        assertThatThrownBy { validator.validatePurchaseAmount("1500") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("The purchase amount must be divisible by 1000.")
    }

    @Test
    fun `validateWinningNumbers should return sorted list when valid`() {
        val result = validator.validateWinningNumbers("1,2,3,4,5,6")
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,a", "1,2,+,4,5,6", "1, ,3,4,5,6", "a,b,c,d,e,6"])
    fun `validateWinningNumbers should throw exception when not a number`(input: String) {
        assertThatThrownBy { validator.validateWinningNumbers(input) }
            .isInstanceOf(ValidationException::class.java)
            .hasMessage("All winning numbers must be numbers.")
    }

    @Test
    fun `validateWinningNumbers should throw exception when not exactly 6 numbers`() {
        assertThatThrownBy { validator.validateWinningNumbers("1,2,3,4,5") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("You must enter exactly 6 numbers.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["0,1,2,3,4,5", "1,2,3,4,5,60"])
    fun `validateWinningNumbers should throw exception when numbers out of range`(input: String) {
        assertThatThrownBy { validator.validateWinningNumbers(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Numbers must be between 1-45.")
    }

    @Test
    fun `validateWinningNumbers should throw exception when numbers are not unique`() {
        assertThatThrownBy { validator.validateWinningNumbers("1,2,3,4,5,5") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Winning numbers must be unique.")
    }

    @Test
    fun `validateBonusNumber should return number when valid`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val result = validator.validateBonusNumber("7", winningNumbers)
        assertThat(result).isEqualTo(7)
    }

    @Test
    fun `validateBonusNumber should throw exception when not a number`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertThatThrownBy { validator.validateBonusNumber("abc", winningNumbers) }
            .isInstanceOf(ValidationException::class.java)
            .hasMessage("The bonus number must be a number.")
    }

    @Test
    fun `validateBonusNumber should throw exception when out of range`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertThatThrownBy { validator.validateBonusNumber("0", winningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Bonus number must be between 1-45.")
    }

    @Test
    fun `validateBonusNumber should throw exception when duplicates winning numbers`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertThatThrownBy { validator.validateBonusNumber("4", winningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("The bonus number must be unique from winning numbers.")
    }
}