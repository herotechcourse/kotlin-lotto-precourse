package lotto.InputValidation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AmountValidationTest {
    private val validator = AmountValidation()

    @Test
    fun `exception Amount 0 exception test`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.ValidateAmount(0)
        }
        assertEquals("[ERROR] Amount entered must be a valid number greater than 0", exception.message)
    }

    @Test
    fun `exception Amount negative Exception`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.ValidateAmount(-3)
        }
        assertEquals("[ERROR] Amount entered must be a valid number greater than 0", exception.message)
    }

    @Test
    fun `exception Amount entered is not multiple of 1000`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.ValidateAmount(3100)
        }
        assertEquals("[ERROR] Amount entered must be multiple of 1000", exception.message)
    }

    @Test
    fun `exception Amount entered is invalid`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.NullCheckAmount("")
        }
        assertEquals("[ERROR] Input needs to be an integer", exception.message)
    }

    @Test
    fun `exception Amount entered is an integer`() {
        val result = validator.NullCheckAmount("2000")
        assertEquals(2000, result)
    }

}