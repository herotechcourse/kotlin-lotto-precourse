package lotto.service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertDoesNotThrow

class InputValidatorTest {

    // 1. validatePurchaseAmount()
    @Test
    fun givenValidPurchaseAmountWhenValidatingThenDoesNotThrow() {
        assertDoesNotThrow { InputValidator.validatePurchaseAmount("1000") }
        assertDoesNotThrow { InputValidator.validatePurchaseAmount("5000") }
    }

    @Test
    fun givenBlankPurchaseAmountWhenValidatingThenThrows() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validatePurchaseAmount("")
        }
    }

    @Test
    fun givenNonNumericPurchaseAmountWhenValidatingThenThrows() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validatePurchaseAmount("abc")
        }
    }

    @Test
    fun givenZeroStartPurchaseAmountWhenValidatingThenThrows() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validatePurchaseAmount("01234")
        }
    }

    @Test
    fun givenUnderMinimumPurchaseAmountWhenValidatingThenThrows() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validatePurchaseAmount("500")
        }
    }

    // 2. validateWinningNumbers()
    @Test
    fun givenValidWinningNumbersWhenValidatingThenDoesNotThrow() {
        assertDoesNotThrow { InputValidator.validateWinningNumbers("1,2,3,4,5,6") }
    }

    @Test
    fun givenBlankWinningNumbersWhenValidatingThenThrows() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateWinningNumbers("")
        }
    }

    @Test
    fun givenNonNumericWinningNumbersWhenValidatingThenThrows() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateWinningNumbers("1,2,three,4,5,6")
        }
    }

    @Test
    fun givenZeroStartWinningNumberWhenValidatingThenThrows() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateWinningNumbers("01,2,3,4,5,6")
        }
    }

    @Test
    fun givenNoCommaWinningNumbersWhenValidatingThenThrows() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateWinningNumbers("1 2 3 4 5 6")
        }
    }

    @Test
    fun givenWrongCountWinningNumbersWhenValidatingThenThrows() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateWinningNumbers("1,2,3,4,5")
        }
    }

    // 3. validateBonusNumber()
    @Test
    fun givenValidBonusNumberWhenValidatingThenDoesNotThrow() {
        assertDoesNotThrow { InputValidator.validateBonusNumber("7") }
    }

    @Test
    fun givenBlankBonusNumberWhenValidatingThenThrows() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateBonusNumber("")
        }
    }

    @Test
    fun givenNonNumericBonusNumberWhenValidatingThenThrows() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateBonusNumber("bonus")
        }
    }

    @Test
    fun givenZeroStartBonusNumberWhenValidatingThenThrows() {
        assertThrows<IllegalArgumentException> {
            InputValidator.validateBonusNumber("07")
        }
    }
}
