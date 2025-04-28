package lotto.validators

import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class InputValidatorsTest {
    @Nested
    inner class ValidateSumOfMoneyTest {
        @Test
        fun `Should not fail if the purchase amount is divisible by 1000`() {
            assertThatCode {
                InputValidator.validateSumOfMoney(3000)
            }.doesNotThrowAnyException()
        }

        @Test
        fun `should fail if the purchase amount isn't divisible by 1000`() {
            assertThatThrownBy {
                InputValidator.validateSumOfMoney(200)
            }.isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(ValidationErrors.MUST_DIVIDE_BY_TICKET_PRICE.message)
        }

        @Test
        fun `should fail if the purchase amount is a null`() {
            assertThatThrownBy {
                InputValidator.validateSumOfMoney(null)
            }.isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(ValidationErrors.MUST_BE_INTEGER.message)
        }

        @Test
        fun `should fail if the purchase amount is 0`() {
            assertThatThrownBy {
                InputValidator.validateSumOfMoney(0)
            }.isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(ValidationErrors.MUST_DIVIDE_BY_TICKET_PRICE.message)
        }

        @Test
        fun `should fail if the purchase amount is negative`() {
            assertThatThrownBy {
                InputValidator.validateSumOfMoney(-1000)
            }.isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(ValidationErrors.MUST_DIVIDE_BY_TICKET_PRICE.message)
        }
    }

    @Nested
    inner class ValidateNumberInRangeTest {
        @Test
        fun `Should not fail if the number is in the range 1-45`() {
            assertThatCode {
                InputValidator.validateNumberInRange(18)
            }.doesNotThrowAnyException()
        }

        @Test
        fun `should fail if the number is not in the range 1-45`() {
            assertThatThrownBy {
                InputValidator.validateNumberInRange(0)
            }.isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(ValidationErrors.MUST_BE_IN_RANGE.message)
        }

        @Test
        fun `should fail if the number is a null`() {
            assertThatThrownBy {
                InputValidator.validateNumberInRange(null)
            }.isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(ValidationErrors.MUST_BE_INTEGER.message)
        }
    }

    @Nested
    inner class ValidateNumbersTest {
        @Test
        fun `should not fail if the list of numbers has 6 elements`() {
            assertThatCode {
                InputValidator.validateNumbers(listOf(1, 13, 25, 27, 39, 41))
            }.doesNotThrowAnyException()
        }

        @Test
        fun `should not fail if the list of numbers has 6 unique elements`() {
            assertThatCode {
                InputValidator.validateNumbers(listOf(2, 14, 25, 29, 34, 41))
            }.doesNotThrowAnyException()
        }

        @Test
        fun `should fail if the list of numbers has not 6 elements`() {
            assertThatThrownBy {
                InputValidator.validateNumbers(listOf(1, 13, 25, 27))
            }.isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(ValidationErrors.MUST_ENTER_SIX_NUMBERS.message)
        }

        @Test
        fun `should fail if the list of numbers has null`() {
            assertThatThrownBy {
                InputValidator.validateNumbers(listOf(1, 13, 25, 27, null, 39))
            }.isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(ValidationErrors.MUST_BE_INTEGER.message)
        }

        @Test
        fun `should fail if the list of numbers hasn't 6 unique elements`() {
            assertThatThrownBy {
                InputValidator.validateNumbers(listOf(1, 13, 25, 27, 27, 39))
            }.isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage(ValidationErrors.MUST_ENTER_UNIQUE_NUMBERS.message)
        }
    }
}
