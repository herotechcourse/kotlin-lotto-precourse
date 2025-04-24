package lotto.view

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class InputValidatorTest {

    private val validator = InputValidator()

    @Test
    fun `throws exception when purchase amount is not divisible by 1000`() {
        // Given
        val invalidInput = "2850"

        // When & Then
        assertThatThrownBy { validator.validatePurchaseAmount(invalidInput) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Purchase amount must be a positive number divisible by 1000.")
    }

    @Test
    fun `throws exception when winning numbers contain non-numeric values`() {
        // Given
        val invalidInput = "1,2,five,4,5,6"

        // When & Then
        assertThatThrownBy { validator.validateWinningNumbers(invalidInput) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid number format.")
    }

    @Test
    fun `throws exception when winning numbers are out of valid range`() {
        // Given
        val invalidInput = "0,2,3,4,5,78"

        // When & Then
        assertThatThrownBy { validator.validateWinningNumbers(invalidInput) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Numbers must be between 1 and 45.")
    }

    @Test
    fun `throws exception when bonus number is not a number`() {
        // Given
        val invalidInput = "jongbinchoi"
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        // When & Then
        assertThatThrownBy { validator.validateBonusNumber(invalidInput, winningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Bonus number must be a number.")
    }

    @Test
    fun `throws exception when bonus number is out of range`() {
        // Given
        val invalidInputs = listOf(0,46)
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        // When & Then
        invalidInputs.forEach { invalidInput ->
            assertThatThrownBy {
                validator.validateBonusNumber(invalidInput.toString(), winningNumbers)
            }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("Bonus number must be between 1 and 45.")
        }
    }

    @Test
    fun `throws exception when bonus number duplicates a winning number`() {
        // Given
        val input = "5"
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        // When & Then
        assertThatThrownBy { validator.validateBonusNumber(input, winningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Bonus number must not duplicate winning numbers.")
    }
}
