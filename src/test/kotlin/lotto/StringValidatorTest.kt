package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class StringValidatorTest {

    @Test
    fun `throws an exception when non numerical characters entered`() {
        val stringValue = "uuu"

        assertThrows<IllegalArgumentException> {
            StringValidator.validateStringToInt(stringValue)
        }
    }

    @Test
    fun `no exception when numerical characters entered`() {
        val stringValue = "9"

        assertDoesNotThrow {
            StringValidator.validateStringToInt(stringValue)
        }
    }

    @Test
    fun `throws an exception when non numerical characters with comma entered`() {
        val stringValue = "1,2,3,4,5,dd"

        assertThrows<IllegalArgumentException> {
            StringValidator.validateStringToIntList(stringValue)
        }
    }

    @Test
    fun `no exception when numerical characters with comma entered`() {
        val stringValue = "1,2,3,4,5,6"

        assertDoesNotThrow {
            StringValidator.validateStringToIntList(stringValue)
        }
    }
}
