package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidatorImplTest {

    private val inputValidator: InputValidator = InputValidatorImpl()

    @Test
    fun `throws an exception for invalid purchase amount input (non-integer)`() {
        val exception = assertThrows<IllegalArgumentException> {
            inputValidator.validatePurchaseAmount("invalid")
        }
        assertThat(exception.message).isEqualTo("Purchase amount must be an integer number greater than or equal 1000 and divisible by 1000.")
    }

    @Test
    fun `throws an exception for purchase amount less than 1000`() {
        val exception = assertThrows<IllegalArgumentException> {
            inputValidator.validatePurchaseAmount("500")
        }
        assertThat(exception.message).isEqualTo("Purchase amount must be an integer number greater than or equal 1000 and divisible by 1000.")
    }

    @Test
    fun `throws an exception for purchase amount not divisible by 1000`() {
        val exception = assertThrows<IllegalArgumentException> {
            inputValidator.validatePurchaseAmount("1500")
        }
        assertThat(exception.message).isEqualTo("Purchase amount must be an integer number greater than or equal 1000 and divisible by 1000.")
    }

    @Test
    fun `returns a valid purchase amount for valid input`() {
        val result = inputValidator.validatePurchaseAmount("10000")

        assertThat(result).isEqualTo(10000)
    }

    @Test
    fun `throws an exception for invalid winning numbers input (non-integer)`() {
        val exception = assertThrows<IllegalArgumentException> {
            inputValidator.validateWinningNumbers("1,2,3,4,5,invalid")
        }
        assertThat(exception.message).isEqualTo("Winning numbers must contain exactly 6 integer numbers separated by comma.")
    }

    @Test
    fun `throws an exception for winning numbers not exactly six numbers`() {
        val lessNumberException = assertThrows<IllegalArgumentException> {
            inputValidator.validateWinningNumbers("1,2,3,4,5")
        }
        assertThat(lessNumberException.message).isEqualTo("Winning numbers must contain exactly 6 integer numbers separated by comma.")

        val moreNumberException = assertThrows<IllegalArgumentException> {
            inputValidator.validateWinningNumbers("1,2,3,4,5,6,7")
        }
        assertThat(moreNumberException.message).isEqualTo("Winning numbers must contain exactly 6 integer numbers separated by comma.")
    }

    @Test
    fun `throws an exception for winning numbers not between 1 and 45`() {
        val exception = assertThrows<IllegalArgumentException> {
            inputValidator.validateWinningNumbers("0,2,3,4,5,46")
        }
        assertThat(exception.message).isEqualTo("Winning numbers must be between 1 and 45.")
    }

    @Test
    fun `throws an exception for duplicate winning numbers`() {
        val exception = assertThrows<IllegalArgumentException> {
            inputValidator.validateWinningNumbers("1,2,2,4,5,6")
        }
        assertThat(exception.message).isEqualTo("Winning numbers must be unique.")
    }

    @Test
    fun `returns valid winning numbers for valid input`() {
        val result = inputValidator.validateWinningNumbers("1,2,3,4,5,6")

        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `throws an exception for invalid bonus number input (non-integer)`() {
        val exception = assertThrows<IllegalArgumentException> {
            inputValidator.validateBonusNumber("invalid")
        }
        assertThat(exception.message).isEqualTo("Bonus number must be a positive integer between 1 and 45.")
    }

    @Test
    fun `throws an exception for bonus number not between 1 and 45`() {
        val exception = assertThrows<IllegalArgumentException> {
            inputValidator.validateBonusNumber("0")
        }
        assertThat(exception.message).isEqualTo("Bonus number must be a positive integer between 1 and 45.")
    }

    @Test
    fun `returns a valid bonus number for valid input`() {
        val result = inputValidator.validateBonusNumber("8")

        assertThat(result).isEqualTo(8)
    }
}
