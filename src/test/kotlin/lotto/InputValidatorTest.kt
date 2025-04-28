package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidatorTest {
    @Test
    fun `throws exception when winning numbers input is blank`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateWinningNumbersInput("")
        }
    }

    @Test
    fun `throws exception when winning numbers contain blank values`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateWinningNumbersInput("1,2,3,,5,6")
        }
    }

    @Test
    fun `throws exception when winning numbers contain non-integer values`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateWinningNumbersInput("1,2,three,4,5,6")
        }
    }

    @Test
    fun `throws exception when bonus number input is blank`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateBonusNumberInput(" ")
        }
    }

    @Test
    fun `throws exception when bonus number input is not an integer`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateBonusNumberInput("7.5")
        }
    }

    @Test
    fun `throws exception when purchase amount input is blank`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validatePurchaseAmount("")
        }
    }

    @Test
    fun `throws exception when purchase amount input is not an integer`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validatePurchaseAmount("1000.5")
        }
    }

    @Test
    fun `throws exception when purchase amount is less than 1,000`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validatePurchaseAmount("500")
        }
    }

    @Test
    fun `throws exception when purchase amount is not divisible by 1,000`() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validatePurchaseAmount("2500")
        }
    }

    @Test
    fun `does not throw exception for valid winning numbers input`() {
        InputValidator.validateWinningNumbersInput("1,2,3,4,5,6")
    }

    @Test
    fun `does not throw exception for valid bonus number input`() {
        InputValidator.validateBonusNumberInput("7")
    }

    @Test
    fun `does not throw exception for valid purchase amount input`() {
        InputValidator.validatePurchaseAmount("3,000")
    }
}