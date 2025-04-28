package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BonusNumberValidatorTest {
    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

    @Test
    fun `throws an exception when bonus number is blank`() {
        val input = " "

        assertThrows<IllegalArgumentException> {
            BonusNumberValidator.validate(input, winningNumbers)
        }
    }

    @Test
    fun `throws an exception when bonus number is not an integer`() {
        val input = "2.5"

        assertThrows<IllegalArgumentException> {
            BonusNumberValidator.validate(input, winningNumbers)
        }
    }

    @Test
    fun `throws an exception when bonus number is out of range`() {
        val input = "46"

        assertThrows<IllegalArgumentException> {
            BonusNumberValidator.validate(input, winningNumbers)
        }
    }

    @Test
    fun `throws an exception when bonus number overlaps with winning numbers`() {
        val input = "5"

        assertThrows<IllegalArgumentException> {
            BonusNumberValidator.validate(input, winningNumbers)
        }
    }

    @Test
    fun `passes when bonus number is valid input without spaces`() {
        val input = "45"

        BonusNumberValidator.validate(input, winningNumbers)
    }

    @Test
    fun `passes when bonus number is valid input with spaces`() {
        val input = "45 "

        BonusNumberValidator.validate(input, winningNumbers)
    }
}