package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidatorTest {
    @Test
    fun `throws when purchase amount is less than 1000`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validatePurchaseAmount(999)
        }
    }

    @Test
    fun `throws when purchase amount is not multiple of 1000`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validatePurchaseAmount(1001)
        }
    }

    @Test
    fun `throws when winning number size is not equal to 6`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateWinningNumbers(listOf(1, 2, 3, 4, 5))
            InputValidator.validateWinningNumbers(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `throws when winning numbers are not unique`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateWinningNumbers(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `throws when winning numbers are not in range of 1-45`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateWinningNumbers(listOf(1, 2, 3, 4, 5, 55))
        }
    }

    @Test
    fun `throws when bonus numbers are not in range of 1-45`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateBonusNumber("50")
        }
    }
}