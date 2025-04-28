package lotto.validators

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class IntegerValidatorTest {

    @Test
    fun `should return integer when input is valid`() {
        val validator = IntegerValidator()
        val result = validator.validate("123")
        assertEquals(123, result)
    }

    @Test
    fun `should throw IllegalArgumentException when input is empty`() {
        val validator = IntegerValidator()
        assertThrows<IllegalArgumentException> { validator.validate("") }
    }

    @Test
    fun `should throw IllegalArgumentException when input is not a number`() {
        val validator = IntegerValidator()
        assertThrows<IllegalArgumentException> { validator.validate("abc") }
    }
}
