package lotto

import lotto.view.InputView
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class InputValidatorTest {
    @Test
    fun shouldThrowExceptionWhenPurchaseAmountIsNotNumeric() {
        assertThatThrownBy { InputView.validatePriceInput("abcd") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun shouldThrowExceptionWhenPurchaseAmountIsNotDivisibleByThousand() {
        assertThatThrownBy { InputView.validatePriceInput("1500") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun shouldThrowExceptionWhenWinningNumbersAreNotSix() {
        assertThatThrownBy { InputView.validateWinNumber("1,2,3,4,5") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun shouldThrowExceptionWhenWinningNumbersAreOutOfRange() {
        assertThatThrownBy { InputView.validateWinNumber("0,1,2,3,4,5") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun shouldThrowExceptionWhenBonusNumberIsDuplicateWithWinningNumbers() {
        val winNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertThatThrownBy { InputView.validateBonusNumber("5", winNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
