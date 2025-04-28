package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertEquals

class BonusNumberTest {

    @Test
    fun `givenValidBonusNumber_whenCreateBonusNumber_thenSuccess`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = BonusNumber(7, winningNumbers)
        assertEquals(7, bonusNumber.value())
    }

    @Test
    fun `givenBonusNumberOutOfRange_whenCreateBonusNumber_thenThrowException`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val invalidBonus = 46
        assertThrows<IllegalArgumentException> {
            BonusNumber(invalidBonus, winningNumbers)
        }
    }

    @Test
    fun `givenBonusNumberDuplicatedWithWinningNumbers_whenCreateBonusNumber_thenThrowException`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val duplicatedBonus = 6
        assertThrows<IllegalArgumentException> {
            BonusNumber(duplicatedBonus, winningNumbers)
        }
    }

    @Test
    fun `givenBonusNumber_whenCallValue_thenReturnBonusNumber`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = BonusNumber(7, winningNumbers)
        assertEquals(7, bonusNumber.value())
    }
}
