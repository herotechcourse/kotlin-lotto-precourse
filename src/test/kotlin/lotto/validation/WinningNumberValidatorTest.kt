package lotto.validation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumberValidatorTest {

    private val validator = WinningNumberValidator()

    @Test
    fun `throws exception when input is blank`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.isNotBlank("  ")
        }
        assertEquals("[ERROR] The input cannot be blank.", exception.message)
    }

    @Test
    fun `throws exception when input does not contain a comma separator`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.containsCommaSeparator("1 2 3 4 5 6")
        }
        assertEquals("[ERROR] The input must contain a comma as a separator.", exception.message)
    }

    @Test
    fun `passes containsCommaSeparator when input contains a comma separator`() {
        assertTrue(validator.containsCommaSeparator("1, 2, 3, 4, 5, 6"))
    }

    @Test
    fun `throws exception when input is not a number`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.validateIsNumber("abc")
        }
        assertEquals("[ERROR] The input must be a valid number.", exception.message)
    }

    @Test
    fun `passes validateIsNumber for valid input`() {
        // This test checks that no exception is thrown when the input is a valid number.
        val result = validator.validateIsNumber("6000")
        assertEquals(6000, result)
    }
}