package lotto.ui

import lotto.util.Constants
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class InputValidationTest {

    @Test
    fun `validatePurchaseAmount should return valid amount when input is valid`() {
        val amount = InputValidation.validatePurchaseAmount("5000")
        assertThat(amount).isEqualTo(5000)
    }

    @Test
    fun `validatePurchaseAmount should throw error when input is non-numeric`() {
        val exception = assertThatThrownBy {
            InputValidation.validatePurchaseAmount("abcd")
        }
        exception.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Constants.ERROR_INVALID_NUMBER)
    }

    @Test
    fun `validatePurchaseAmount should throw error when input is less than minimum purchase amount`() {
        val exception = assertThatThrownBy {
            InputValidation.validatePurchaseAmount("500")
        }
        exception.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Constants.ERROR_INVALID_PURCHASE_AMOUNT)
    }

    @Test
    fun `validatePurchaseAmount should throw error when input can't divide by purchase amount unit`() {
        val exception = assertThatThrownBy {
            InputValidation.validatePurchaseAmount("1500")
        }
        exception.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Constants.ERROR_INVALID_PURCHASE_UNIT)
    }

    @Test
    fun `validateBonusNumber should return valid bonus number when input is valid`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = InputValidation.validateBonusNumber("7", winningNumbers)
        assertThat(bonusNumber).isEqualTo(7)
    }

    @Test
    fun `validateBonusNumber should throw error when input is non-numeric`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val exception = assertThatThrownBy {
            InputValidation.validateBonusNumber("abcd", winningNumbers)
        }
        exception.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Constants.ERROR_INVALID_BONUS_NUMBER)
    }

    @Test
    fun `validateBonusNumber should throw error when bonus number is out of range`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val exception = assertThatThrownBy {
            InputValidation.validateBonusNumber("46", winningNumbers)
        }
        exception.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Constants.ERROR_BONUS_OUT_OF_RANGE)
    }

    @Test
    fun `validateBonusNumber should throw error when bonus number is a duplicate of winning numbers`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val exception = assertThatThrownBy {
            InputValidation.validateBonusNumber("3", winningNumbers)
        }
        exception.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Constants.ERROR_DUPLICATE_BONUS_NUMBER)
    }
}
