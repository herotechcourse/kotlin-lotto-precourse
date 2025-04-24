package lotto.validation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PurchaseAmountValidatorTest {

    private val validator = PurchaseAmountValidator()

    @Test
    fun `throws exception when input is not a number`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.validateIsNumber("abc")
        }
        assertEquals("[ERROR] The input must be a valid number.", exception.message)
    }

    @Test
    fun `returns number when input is valid`() {
        val result = validator.validateIsNumber("5000")
        assertEquals(5000, result)
    }

    @Test
    fun `throws exception when amount is not divisible by 1000`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.validateIsDivisibleByThousand(5500)
        }
        assertEquals("[ERROR] The purchase amount must be divisible by 1000.", exception.message)
    }

    @Test
    fun `passes when amount is divisible by 1000`() {
        assertTrue(validator.validateIsDivisibleByThousand(3000))
    }

    @Test
    fun `throws exception in validatePurchaseAmount for invalid input`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.validatePurchaseAmount("12a00")
        }
        assertEquals("[ERROR] The input must be a valid number.", exception.message)
    }

    @Test
    fun `throws exception in validatePurchaseAmount for not divisible amount`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.validatePurchaseAmount("1234")
        }
        assertEquals("[ERROR] The purchase amount must be divisible by 1000.", exception.message)
    }

    @Test
    fun `passes validatePurchaseAmount for valid input`() {
        val result = validator.validatePurchaseAmount("6000")
        assertEquals(6000, result)
    }
}