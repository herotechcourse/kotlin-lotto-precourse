package lotto.validator

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BonusNumberValidatorTest {
    @Test
    fun `throws exception when bonus number is not numeric`() {
        val invalidBonusNumber = "A"
        val winningNumbers = listOf("1", "2", "3", "4", "5", "6")

        val exception = assertThrows(IllegalArgumentException::class.java) {
            BonusNumberValidator.validate(invalidBonusNumber, winningNumbers)
        }
        assertEquals("[ERROR] Bonus number must be numeric value.", exception.message)
    }

    @Test
    fun `throws exception when bonus number is out of range`() {
        val invalidBonusNumber = "46"
        val winningNumbers = listOf("1", "2", "3", "4", "5", "6")

        val exception = assertThrows(IllegalArgumentException::class.java) {
            BonusNumberValidator.validate(invalidBonusNumber, winningNumbers)
        }
        assertEquals("[ERROR] Bonus number must be between 1 and 45.", exception.message)
    }

    @Test
    fun `throws exception when bonus number is duplicate of winning numbers`() {
        val invalidBonusNumber = "1"
        val winningNumbers = listOf("1", "2", "3", "4", "5", "6")

        val exception = assertThrows(IllegalArgumentException::class.java) {
            BonusNumberValidator.validate(invalidBonusNumber, winningNumbers)
        }
        assertEquals("[ERROR] Bonus number must be different from the winning numbers.", exception.message)
    }

}