package lotto.InputValidation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class AmountValidationTest {
    private val validator = AmountValidation()

    @Test
    fun `exception purchase amount is 0 exception test`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.ValidateAmountPositive(0)
        }
        assertEquals("[ERROR] Amount entered must be a valid number greater than 0", exception.message)
    }

    @Test
    fun `exception purchase amount is negative Exception`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.ValidateAmountPositive(-3)
        }
        assertEquals("[ERROR] Amount entered must be a valid number greater than 0", exception.message)
    }

    @Test
    fun `exception purchase amount entered is not multiple of 1000`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.ValidateAmountMultipleOfThousand(3100)
        }
        assertEquals("[ERROR] Amount entered must be multiple of 1000", exception.message)
    }

    @Test
    fun `exception purchase amount entered is invalid`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.NullCheckNumber("")
        }
        assertEquals("[ERROR] Input needs to be an integer", exception.message)
    }

    @Test
    fun `exception purchase amount entered is a valid number`() {
        val result = validator.NullCheckNumber("3000")

        assertEquals(3000, result)
    }


}