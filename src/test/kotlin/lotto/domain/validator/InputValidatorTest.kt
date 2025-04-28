package lotto.domain.validator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputValidatorTest {
    @Nested
    inner class ValidatePurchaseAmountTest {
        @Test
        fun `returns purchase amount as integer when valid`() {
            val result = InputValidator.validatePurchaseAmount("3000")
            assertThat(result).isEqualTo(3000)
        }

        @Test
        fun `throws an exception when input is blank`() {
            assertThrows<IllegalArgumentException> {
                InputValidator.validatePurchaseAmount(" ")
            }
        }

        @Test
        fun `throws an exception when input is not a number`() {
            assertThrows<IllegalArgumentException> {
                InputValidator.validatePurchaseAmount("abc")
            }
        }

        @Test
        fun `throws an exception when input is not divisible by ticket price`() {
            assertThrows<IllegalArgumentException> {
                InputValidator.validatePurchaseAmount("1500")
            }
        }

        @Test
        fun `returns winning numbers set when valid`() {
            val result = InputValidator.validateWinningNumbers("1, 2, 3, 4, 5, 6")
            assertThat(result).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6)
        }
    }

    @Nested
    inner class ValidateWinningNumbersTest {
        @Test
        fun `throws an exception when input is blank`() {
            assertThrows<IllegalArgumentException> {
                InputValidator.validateWinningNumbers(" ")
            }
        }

        @Test
        fun `throws an exception when count is not 6`() {
            assertThrows<IllegalArgumentException> {
                InputValidator.validateWinningNumbers("1,2,3,4,5")
            }
        }

        @Test
        fun `throws an exception when there are duplicate numbers`() {
            assertThrows<IllegalArgumentException> {
                InputValidator.validateWinningNumbers("1,2,3,3,4,5")
            }
        }

        @Test
        fun `throws an exception when number is not valid`() {
            assertThrows<IllegalArgumentException> {
                InputValidator.validateWinningNumbers("1,2,3,4,5,abc")
            }
        }

        @Test
        fun `throws an exception when number is out of valid range`() {
            assertThrows<IllegalArgumentException> {
                InputValidator.validateWinningNumbers("0,2,3,4,5,6")
            }
        }

        @Test
        fun `returns bonus number when valid`() {
            val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
            val result = InputValidator.validateBonusNumber("7", winningNumbers)
            assertThat(result).isEqualTo(7)
        }
    }

    @Nested
    inner class ValidateBonusNumberTest {
        @Test
        fun `throws an exception when input is blank`() {
            val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
            assertThrows<IllegalArgumentException> {
                InputValidator.validateBonusNumber(" ", winningNumbers)
            }
        }

        @Test
        fun `throws an exception when input is not a number`() {
            val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
            assertThrows<IllegalArgumentException> {
                InputValidator.validateBonusNumber("abc", winningNumbers)
            }
        }

        @Test
        fun `throws an exception when bonus number is out of valid range`() {
            val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
            assertThrows<IllegalArgumentException> {
                InputValidator.validateBonusNumber("0", winningNumbers)
            }
        }

        @Test
        fun `throws an exception when bonus number is duplicated with winning numbers`() {
            val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
            assertThrows<IllegalArgumentException> {
                InputValidator.validateBonusNumber("6", winningNumbers)
            }
        }
    }
}