package lotto

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.Test

class ValidatorTest {
    @Test
    fun `passes when purchase amount is a multiple of 1000`() {
        assertThatCode { Validator.validatePurchaseAmount(3000) }
            .doesNotThrowAnyException()
    }

    @Test
    fun `throws exception when purchase amount is not a multiple of 1000`() {
        assertThatThrownBy { Validator.validatePurchaseAmount(1111) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Constants.ERROR_MULTIPLE_OF_1000)
    }

    @Test
    fun `throws exception when winning numbers are less than 6`() {
        assertThatThrownBy { Validator.validateWinningNumbers(listOf(1, 2, 3, 4, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Constants.ERROR_INVALID_WINNING_COUNT)
    }

    @Test
    fun `passed correct winning numbers`() {
        assertThatCode { Validator.validateWinningNumbers(listOf(1, 2, 3, 4, 5, 6)) }
            .doesNotThrowAnyException()
    }

    @Test
    fun `throws an exception when winning numbers are not between 1 and 45`() {
        assertThatThrownBy { Validator.validateWinningNumbers(listOf(1, 2, 3, 4, 5, 50)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Constants.ERROR_INVALID_NUMBER_RANGE)
    }

    @Test
    fun `throws an exception when winning numbers contain duplicates`() {
        assertThatThrownBy { Validator.validateWinningNumbers(listOf(1, 2, 3, 4, 5, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Constants.ERROR_DUPLICATED_NUMBER)
    }

    @Test
    fun `passes correct bonus number`() {
        assertThatCode { Validator.validateBonusNumber(7, listOf(1, 2, 3, 4, 5, 6)) }
            .doesNotThrowAnyException()
    }

    @Test
    fun `throws an exception when bonus number is not between 1 and 45`() {
        assertThatThrownBy { Validator.validateBonusNumber(50, listOf(1, 2, 3, 4, 5, 6)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Constants.ERROR_INVALID_BONUS_NUMBER_RANGE)
    }

    @Test
    fun `throws an exception when bonus number contains duplicates`() {
        assertThatThrownBy { Validator.validateBonusNumber(5, listOf(1, 2, 3, 4, 5, 6)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Constants.ERROR_DUPLICATED_BONUS)
    }
}