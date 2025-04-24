package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class ValidatorTest {

    @Test
    fun `throws an exception when non numerical characters entered`() {
        val validator = Validator()
        val stringValue = "uuu"

        assertThrows<IllegalArgumentException> {
            validator.validateStringToInt(stringValue)
        }
    }

    @Test
    fun `no exception when numerical characters entered`() {
        val validator = Validator()
        val stringValue = "9"

        assertDoesNotThrow {
            validator.validateStringToInt(stringValue)
        }
    }
}
