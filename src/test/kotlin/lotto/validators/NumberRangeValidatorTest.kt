package lotto.validators

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NumberRangeValidatorTest {

    @Test
    fun `should return number when number is within range`() {
        val validator = NumberRangeValidator(1, 45)
        val result = validator.validate("25")
        assertEquals(25, result)
    }

    @Test
    fun `should throw IllegalArgumentException when number is below the range`() {
        val validator = NumberRangeValidator(1, 45)
        assertThrows<IllegalArgumentException> { validator.validate("0") }
    }

    @Test
    fun `should throw IllegalArgumentException when number is above the range`() {
        val validator = NumberRangeValidator(1, 45)
        assertThrows<IllegalArgumentException> { validator.validate("46") }
    }

    @Test
    fun `should throw IllegalArgumentException when input is not a valid number`() {
        val validator = NumberRangeValidator(1, 45)
        assertThrows<IllegalArgumentException> { validator.validate("abc") }
    }
}
