package lotto.validators

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class DivisibleByValidatorTest {

    @Test
    fun `should throw IllegalArgumentException when divisor is zero`() {
        assertThrows<IllegalArgumentException> { DivisibleByValidator(0) }
    }

    @Test
    fun `should return input when it is divisible by the divisor`() {
        val validator = DivisibleByValidator(5)
        val result = validator.validate("10")
        assertEquals(10, result)
    }

    @Test
    fun `should throw IllegalArgumentException when input is not divisible by the divisor`() {
        val validator = DivisibleByValidator(5)
        assertThrows<IllegalArgumentException> { validator.validate("7") }
    }

    @Test
    fun `should throw IllegalArgumentException when input is not a valid number`() {
        val validator = DivisibleByValidator(5)
        assertThrows<NumberFormatException> { validator.validate("abc") }
    }
}
