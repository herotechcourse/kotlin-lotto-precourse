package lotto.domain.validator

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest {
    @Test
    fun `throws an exception when the number list is smaller than lotto size 6`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateCount(listOf(1, 2, 3, 4, 5))
        }
    }

    @Test
    fun `throws an exception when the number list contain duplicates`() {
        assertThrows<IllegalArgumentException> {
            Validator.validateDuplication(listOf(1, 2, 3, 3, 4, 5))
        }
    }

    @Test
    fun `throws an exception when the number is smaller than 1`() {
        assertThrows<IllegalArgumentException> {
            listOf(0, 2, 3, 4, 5, 6).forEach { Validator.validateRange(it) }
        }
    }

    @Test
    fun `throws an exception when the number is larger than 45`() {
        assertThrows<IllegalArgumentException> {
            listOf(1, 2, 3, 4, 5, 46).forEach { Validator.validateRange(it) }
        }
    }

    @Test
    fun `throws an exception when the extra number is contained in the number list`() {
        val bonusNumber = 1
        val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
        assertThrows<IllegalArgumentException> {
            Validator.validateDuplicateOfBonusNumber(bonusNumber, winningNumbers)
        }
    }
}