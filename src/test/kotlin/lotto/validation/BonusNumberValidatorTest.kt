package lotto.validation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberValidatorTest {

    private val validator = BonusNumberValidator(WinningNumberValidator())

    @Test
    fun `throws exception when input is blank`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.validateBonusNumber("  ")
        }
        assertEquals("[ERROR] The input cannot be blank.", exception.message)
    }

    @Test
    fun `throws exception when input is not a number`() {
        val exception = assertThrows<IllegalArgumentException> {
            validator.validateBonusNumber("abc")
        }
        assertEquals("[ERROR] The input must be a valid number.", exception.message)
    }

    @Test
    fun `validates valid bonus number successfully`() {
        assertEquals(45, validator.validateBonusNumber("45"))
    }
}