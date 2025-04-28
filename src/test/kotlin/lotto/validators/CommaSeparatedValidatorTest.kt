package lotto.validators

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CommaSeparatedValidatorTest {

    @Test
    fun `should return list of integers when input is valid`() {
        val validator = CommaSeparatedValidator()
        val result = validator.validate("1,2,3,4,5,6")
        assertEquals(listOf(1, 2, 3, 4, 5, 6), result)
    }

    @Test
    fun `should throw IllegalArgumentException when input is not comma-separated`() {
        val validator = CommaSeparatedValidator()
        assertThrows<IllegalArgumentException> { validator.validate("1 2 3 4 5 6") }
    }

    @Test
    fun `should throw IllegalArgumentException when input contains invalid numbers`() {
        val validator = CommaSeparatedValidator()
        assertThrows<IllegalArgumentException> { validator.validate("1,2,abc,4,5,6") }
    }
}
