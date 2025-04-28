package lotto.utils

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class ValidatorTest {

    @Test
    fun `throws error when input is blank`() {
        assertThatThrownBy { Validator.validateNumber("") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("must not be blank")
    }

    @Test
    fun `throws error when input is not a number`() {
        assertThatThrownBy { Validator.validateNumber("abc") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("must be a valid number")
    }

    @Test
    fun `throws error when input is a negative number`() {
        assertThatThrownBy { Validator.validateNumber("-5") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Number must be greater than or equal to 1")
    }

    @Test
    fun `success when input is a positive number`() {
        Validator.validateNumber("5") // No exception expected
    }

    @Test
    fun `throws error when purchase amount is less than 1000`() {
        assertThatThrownBy { Validator.validatePurchaseAmount("500") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("at least 1000")
    }

    @Test
    fun `throws error when purchase amount is not divisible by 1000`() {
        assertThatThrownBy { Validator.validatePurchaseAmount("1500") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("divisible by 1000")
    }

    @Test
    fun `success when purchase amount is valid`() {
        Validator.validatePurchaseAmount("2000") // No exception expected
    }

    @Test
    fun `throws error when number list size is not six`() {
        assertThatThrownBy { Validator.validateNumberListSize(listOf("1", "2", "3")) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("exactly 6 numbers")
    }

    @Test
    fun `success when number list size is six`() {
        Validator.validateNumberListSize(listOf("1", "2", "3", "4", "5", "6")) // No exception expected
    }

    @Test
    fun `throws error when validating all numbers and one is invalid`() {
        assertThatThrownBy { Validator.validateAllNumbers(listOf("1", "2", "abc", "4", "5", "6")) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("must be a valid number")
    }

    @Test
    fun `success when validating all valid numbers`() {
        Validator.validateAllNumbers(listOf("1", "2", "3", "4", "5", "6")) // No exception expected
    }
}