package lotto.validators

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CombinedValidatorTest {

    @Test
    fun `should throw IllegalArgumentException when no validators are provided`() {
        assertThrows<IllegalArgumentException> { CombinedValidator<Int>(emptyList()) }
    }

    @Test
    fun `should pass validation when all validators succeed`() {
        val validator1 = IntegerValidator()
        val validator2 =
                object : InputValidator<Int> {
                    override fun validate(input: String): Int {
                        return input.toInt() * 2
                    }
                }
        val combinedValidator = CombinedValidator(listOf(validator1, validator2))
        val result = combinedValidator.validate("123")
        assertEquals(246, result)
    }

    @Test
    fun `should throw exception when one of the validators fails`() {
        val validator1 = IntegerValidator()
        val validator2 =
                object : InputValidator<Int> {
                    override fun validate(input: String): Int {
                        throw IllegalArgumentException("Invalid input")
                    }
                }
        val combinedValidator = CombinedValidator(listOf(validator1, validator2))
        assertThrows<IllegalArgumentException> { combinedValidator.validate("123") }
    }
}
