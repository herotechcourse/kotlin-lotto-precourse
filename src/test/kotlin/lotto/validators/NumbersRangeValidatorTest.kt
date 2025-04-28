package lotto.validators

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NumbersRangeValidatorTest {

    @Test
    fun `should return input when all numbers are within range`() {
        val validator = NumbersRangeValidator(1, 45)
        val result = validator.validate("1,2,3,4,5,6")
        assertEquals(listOf(1, 2, 3, 4, 5, 6), result)
    }

    @Test
    fun `should throw IllegalArgumentException when a number is below the range`() {
        val validator = NumbersRangeValidator(1, 45)
        assertThrows<IllegalArgumentException> { validator.validate("0,2,3,4,5,6") }
    }

    @Test
    fun `should throw IllegalArgumentException when a number is above the range`() {
        val validator = NumbersRangeValidator(1, 45)
        assertThrows<IllegalArgumentException> { validator.validate("1,2,3,4,5,46") }
    }
}
