package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class ValidatorTest {

    @Test
    fun `throws an exception when non numerical characters entered`() {
        val stringValue = "uuu"

        assertThrows<IllegalArgumentException> {
            Validator.validateStringToInt(stringValue)
        }
    }

    @Test
    fun `no exception when numerical characters entered`() {
        val stringValue = "9"

        assertDoesNotThrow {
            Validator.validateStringToInt(stringValue)
        }
    }

    @Test
    fun `throws an exception when non numerical characters with comma entered`() {
        val stringValue = "1,2,3,4,5,dd"

        assertThrows<IllegalArgumentException> {
            Validator.validateStringToIntList(stringValue)
        }
    }

    @Test
    fun `no exception when numerical characters with comma entered`() {
        val stringValue = "1,2,3,4,5,6"

        assertDoesNotThrow {
            Validator.validateStringToIntList(stringValue)
        }
    }
}
