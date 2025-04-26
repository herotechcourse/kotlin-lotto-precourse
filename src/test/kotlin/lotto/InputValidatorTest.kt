package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class InputValidatorTest {

    @Test
    fun `should throw error when purchase amount is not a number`() {
        val input = "book"
        val exception = assertThrows<IllegalArgumentException> {
            InputValidator.validatePurchaseAmountInput(input)
        }
        assertThat(exception).hasMessageContaining("[ERROR] The amount has to be a number!")
    }

    @Test
    fun `should throw error when lottery numbers input is empty`() {
        val input = ""
        val exception = assertThrows<IllegalArgumentException> {
            InputValidator.validateLotteryNumbersInput(input)
        }
        assertThat(exception).hasMessageContaining("[ERROR] All entries must be numbers!")
    }

    @Test
    fun `should return valid amount when input is multiple of 1000`() {
        val input = "2000"
        val result = InputValidator.validatePurchaseAmountInput(input)
        assertThat(result).isEqualTo(2000)
    }

    @Test
    fun `should throw error when purchase amount is not a multiple of 1000`() {
        val input = "1500"
        val exception = assertThrows<IllegalArgumentException> {
            InputValidator.validatePurchaseAmountInput(input)
        }
        assertThat(exception).hasMessageContaining("[ERROR] The purchase amount must be divisible by 1000!")
    }

    @Test
    fun `should return valid lottery numbers when input is valid`() {
        val input = "1, 2, 3, 4, 5, 6"
        val result = InputValidator.validateLotteryNumbersInput(input)
        assertThat(result).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `should handle input with extra spaces or commas`() {
        val input = "  1 ,  2 , 3  , 4  , 5 ,  6  "
        val result = InputValidator.validateLotteryNumbersInput(input)
        assertThat(result).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `should return valid bonus number when input is valid`() {
        val input = "7"
        val result = InputValidator.validateBonusNumber(input)
        assertThat(result).isEqualTo(7)
    }

    @Test
    fun `should throw error when bonus number is not a number`() {
        val input = "car"
        val exception = assertThrows<IllegalArgumentException> {
            InputValidator.validateBonusNumber(input)
        }
        assertThat(exception).hasMessageContaining("[ERROR] The bonus number has to be a number!")
    }

    @Test
    fun `should throw error when bonus number input is empty`() {
        val input = ""
        val exception = assertThrows<IllegalArgumentException> {
            InputValidator.validateBonusNumber(input)
        }
        assertThat(exception).hasMessageContaining("[ERROR] The bonus number has to be a number!")
    }

    @Test
    fun `should throw error when bonus number is out of range`() {
        val input = "46"
        val exception = assertThrows<IllegalArgumentException> {
            InputValidator.validateBonusNumber(input)
        }
        assertThat(exception).hasMessageContaining("[ERROR] Each number must be between 1 and 45.")
    }
}
