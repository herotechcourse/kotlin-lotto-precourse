package lotto.validation

import org.assertj.core.api.Assertions.* // Use AssertJ assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

/**
 * Unit tests for the [LottoValidator] object.
 */
class LottoValidatorTest {

    @Test
    fun `validatePurchaseAmount should pass for valid amount`() {
        // given
        val validAmount = "3000"

        // when
        val result = LottoValidator.validatePurchaseAmount(validAmount)

        // then
        assertThat(result).isEqualTo(3000)
    }

    @Test
    fun `validatePurchaseAmount should throw exception for non-numeric input`() {
        // given
        val invalidAmount = "abc"

        // when & then
        assertThatThrownBy { LottoValidator.validatePurchaseAmount(invalidAmount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Purchase amount must be a number.")
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-1000"])
    fun `validatePurchaseAmount should throw exception for non-positive amount`(input: String) {
        // given
        val invalidAmount = input

        // when & then
        assertThatThrownBy { LottoValidator.validatePurchaseAmount(invalidAmount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Purchase amount must be greater than 0.")
    }

    @Test
    fun `validatePurchaseAmount should throw exception if amount is not multiple of 1000`() {
        // given
        val invalidAmount = "1500"

        // when & then
        assertThatThrownBy { LottoValidator.validatePurchaseAmount(invalidAmount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR] Purchase amount must be a multiple of 1000.")
    }

    @Test
    fun `validateWinningNumbersInput should pass for valid input`() {
        // given
        val validInput = "1,2,3,4,5,6"

        // when
        val result = LottoValidator.validateWinningNumbersInput(validInput)

        // then
        assertThat(result).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `validateWinningNumbersInput should throw exception for invalid format or numbers`() {
        // given
        val invalidInputs = listOf(
            "1,2,3,4,5" to "exactly 6 numbers", // Wrong count
            "1,2,3,4,5,6,7" to "exactly 6 numbers", // Wrong count
            "1,2,3,4,5,5" to "cannot contain duplicates", // Duplicates
            "1,2,3,4,5,46" to "between 1 and 45", // Out of range
            "1,2,3,4,5,a" to "must be numeric", // Not numeric
            "1, 2, 3, 4, 5" to "exactly 6 numbers" // Wrong count with spaces
        )

        // when & then
        invalidInputs.forEach { (invalidInput, expectedErrorMsg) ->
            assertThatThrownBy { LottoValidator.validateWinningNumbersInput(invalidInput) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining(expectedErrorMsg)
        }
    }

    @Test
    fun `validateLottoNumbers should pass for valid numbers`() {
        // given
        val validNumbers = listOf(1, 2, 3, 4, 5, 6)

        // when & then (no exception should be thrown)
        LottoValidator.validateLottoNumbers(validNumbers)
    }

    @Test
    fun `validateLottoNumbers should throw exception for invalid size`() {
        // given
        val tooFewNumbers = listOf(1, 2, 3, 4, 5)
        val tooManyNumbers = listOf(1, 2, 3, 4, 5, 6, 7)

        // when & then
        assertThatThrownBy { LottoValidator.validateLottoNumbers(tooFewNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("exactly 6 numbers")
        assertThatThrownBy { LottoValidator.validateLottoNumbers(tooManyNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("exactly 6 numbers")
    }

    @Test
    fun `validateLottoNumbers should throw exception for duplicates`() {
        // given
        val numbersWithDuplicates = listOf(1, 2, 3, 4, 5, 5)

        // when & then
        assertThatThrownBy { LottoValidator.validateLottoNumbers(numbersWithDuplicates) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("cannot contain duplicates")
    }

    @Test
    fun `validateLottoNumbers should throw exception for numbers out of range`() {
        // given
        val numbersWithTooHighValue = listOf(1, 2, 3, 4, 5, 46)
        val numbersWithTooLowValue = listOf(0, 2, 3, 4, 5, 6)

        // when & then
        assertThatThrownBy { LottoValidator.validateLottoNumbers(numbersWithTooHighValue) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("between 1 and 45")
        assertThatThrownBy { LottoValidator.validateLottoNumbers(numbersWithTooLowValue) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("between 1 and 45")
    }

    @Test
    fun `validateBonusNumber should pass for valid bonus number`() {
        // given
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val validBonusNumber = "7"

        // when
        val result = LottoValidator.validateBonusNumber(validBonusNumber, winningNumbers)

        // then
        assertThat(result).isEqualTo(7)
    }

    @Test
    fun `validateBonusNumber should throw exception for non-numeric input`() {
        // given
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val invalidBonusNumber = "a"

        // when & then
        assertThatThrownBy { LottoValidator.validateBonusNumber(invalidBonusNumber, winningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("must be numeric")
    }

    @Test
    fun `validateBonusNumber should throw exception for number out of range`() {
        // given
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val tooHighBonusNumber = "46"
        val tooLowBonusNumber = "0"

        // when & then
        assertThatThrownBy { LottoValidator.validateBonusNumber(tooHighBonusNumber, winningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("between 1 and 45")
        assertThatThrownBy { LottoValidator.validateBonusNumber(tooLowBonusNumber, winningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("between 1 and 45")
    }

    @Test
    fun `validateBonusNumber should throw exception if bonus number duplicates a winning number`() {
        // given
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val duplicateBonusNumber = "6"

        // when & then
        assertThatThrownBy { LottoValidator.validateBonusNumber(duplicateBonusNumber, winningNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("cannot be the same as a winning number")
    }
}
