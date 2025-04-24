package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class ValidatorTest {

    private val validator = Validator()

    @Test
    fun `throws an exception when non numerical characters entered`() {
        val stringValue = "uuu"

        assertThrows<IllegalArgumentException> {
            validator.validateStringToInt(stringValue)
        }
    }

    @Test
    fun `no exception when numerical characters entered`() {
        val stringValue = "9"

        assertDoesNotThrow {
            validator.validateStringToInt(stringValue)
        }
    }

    @Test
    fun `throws an exception when bonus number duplicate with winning numbers`() {
        val bonusNumber = "4"
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        assertThrows<IllegalArgumentException> {
            validator.validateBonusNumber(bonusNumber, winningNumbers)
        }
    }

    @Test
    fun `no exception when bonus number not duplicate with winning numbers`() {
        val bonusNumber = "10"
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        assertDoesNotThrow {
            validator.validateBonusNumber(bonusNumber, winningNumbers)
        }
    }
}
