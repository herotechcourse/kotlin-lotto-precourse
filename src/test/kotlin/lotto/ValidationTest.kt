import lotto.utils.InputValidator
import lotto.view.messages.PurchaseErrorMessage
import lotto.view.messages.WinningNumberErrorMessage
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class ValidationTest {

    private val validator = InputValidator()

    // --- Purchase Amount Tests ---

    @Test
    fun `should return valid amount when input is correct`() {
        val input = "3000"
        val result = validator.validatePurchaseInput(input)
        assertThat(result).isEqualTo(3000)
    }

    @Test
    fun `should throw when input is not a number`() {
        val input = "abc"
        assertThatThrownBy { validator.validatePurchaseInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(PurchaseErrorMessage.NOT_A_NUMBER.message)
    }

    @Test
    fun `should throw when input is negative`() {
        val input = "-1000"
        assertThatThrownBy { validator.validatePurchaseInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(PurchaseErrorMessage.NEGATIVE_NUMBER.message)
    }

    @Test
    fun `should throw when input is less than 1000`() {
        val input = "500"
        assertThatThrownBy { validator.validatePurchaseInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(PurchaseErrorMessage.LESS_THAN_MINIMUM.message)
    }

    @Test
    fun `should throw when input is not a multiple of 1000`() {
        val input = "1200"
        assertThatThrownBy { validator.validatePurchaseInput(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(PurchaseErrorMessage.NOT_A_MULTIPLE_OF_1000.message)
    }

    // --- Winning Numbers Tests ---

    @Test
    fun `should return valid winning numbers when input is correct`() {
        val input = "8, 21, 23, 41, 42, 43"
        val result = validator.validateWinningNumbers(input)
        assertThat(result).containsExactlyInAnyOrder(8, 21, 23, 41, 42, 43)
    }

    @Test
    fun `should throw when winning numbers are not six numbers`() {
        val input = "8, 21, 23, 41, 42"
        assertThatThrownBy { validator.validateWinningNumbers(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(WinningNumberErrorMessage.NOT_SIX_NUMBERS.message)
    }

    @Test
    fun `should throw when winning numbers contain non-number`() {
        val input = "8, 21, abc, 41, 42, 43"
        assertThatThrownBy { validator.validateWinningNumbers(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(WinningNumberErrorMessage.NOT_A_NUMBER.message)
    }

    @Test
    fun `should throw when winning numbers are out of range`() {
        val input = "0, 21, 23, 41, 42, 43"
        assertThatThrownBy { validator.validateWinningNumbers(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(WinningNumberErrorMessage.NOT_IN_RANGE.message)
    }

    @Test
    fun `should throw when winning numbers have duplicates`() {
        val input = "8, 21, 23, 21, 42, 43"
        assertThatThrownBy { validator.validateWinningNumbers(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(WinningNumberErrorMessage.DUPLICATE_NUMBER.message)
    }

    // --- Bonus Number Tests ---

    @Test
    fun `should return valid bonus number when input is correct`() {
        val winningNumbers = setOf(8, 21, 23, 41, 42, 43)
        val bonusInput = "7"
        val result = validator.validateBonusNumber(bonusInput, winningNumbers)
        assertThat(result).isEqualTo(7)
    }

    @Test
    fun `should throw when bonus number is duplicate of winning numbers`() {
        val winningNumbers = setOf(8, 21, 23, 41, 42, 43)
        val bonusInput = "8"
        assertThatThrownBy { validator.validateBonusNumber(bonusInput, winningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(WinningNumberErrorMessage.BONUS_NUMBER_DUPLICATE.message)
    }
}
