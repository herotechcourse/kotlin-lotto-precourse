package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class WinningNumberValidatorTest {
    @Test
    fun `throws an exception when winning numbers contain non-integer values`() {
        val input = "1,2,3,4,5,a"

        assertThrows<IllegalArgumentException> {
            WinningNumberValidator.validate(input)
        }
    }

    @Test
    fun `throws an exception when winning numbers contain decimal values`() {
        val input = "1, 2, 3.5, 4, 5, 6"

        assertThrows<IllegalArgumentException> {
            WinningNumberValidator.validate(input)
        }
    }

    @Test
    fun `throws an exception when winning numbers contain blank or null values`() {
        val input = "1,2, ,4,5,6"

        assertThrows<IllegalArgumentException> {
            WinningNumberValidator.validate(input)
        }
    }

    @Test
    fun `throws an exception when winning numbers are not exactly six`() {
        val input = "1,2,3,4,5"

        assertThrows<IllegalArgumentException> {
            WinningNumberValidator.validate(input)
        }
    }

    @Test
    fun `throws an exception when winning numbers contain number out of range`() {
        val input = "1,2,3,4,5,89"

        assertThrows<IllegalArgumentException> {
            WinningNumberValidator.validate(input)
        }
    }

    @Test
    fun `throws an exception when winning numbers contain duplicates`() {
        val input = "1,2,3,4,5,5"

        assertThrows<IllegalArgumentException> {
            WinningNumberValidator.validate(input)
        }
    }

    @Test
    fun `passes when winning numbers are valid input without spaces`() {
        val input = "1,2,3,4,5,6"

        WinningNumberValidator.validate(input)
    }

    @Test
    fun `passes when winning numbers are valid input with spaces`() {
        val input = "1, 2, 3, 4, 5, 6"

        WinningNumberValidator.validate(input)
    }
}