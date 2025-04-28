package lotto.validators

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UniqueNumbersValidatorTest {

    @Test
    fun `should return list of numbers when all numbers are unique`() {
        val validator = UniqueNumbersValidator()
        val result = validator.validate("1,2,3,4,5,6")
        assertEquals(listOf(1, 2, 3, 4, 5, 6), result)
    }

    @Test
    fun `should throw IllegalArgumentException when there are duplicate numbers`() {
        val validator = UniqueNumbersValidator()
        assertThrows<IllegalArgumentException> { validator.validate("1,2,3,4,5,5") }
    }

    @Test
    fun `should handle single number input`() {
        val validator = UniqueNumbersValidator()
        val result = validator.validate("1")
        assertEquals(listOf(1), result)
    }

    @Test
    fun `should throw IllegalArgumentException when input is empty`() {
        val validator = UniqueNumbersValidator()
        assertThrows<IllegalArgumentException> { validator.validate("") }
    }
}
