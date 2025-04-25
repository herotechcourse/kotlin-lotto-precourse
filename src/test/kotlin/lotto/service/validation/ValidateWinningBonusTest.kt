package lotto.service.validation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertEquals

/**
 *  [ Test list ]
 *  1. Valid bonus number               Pass
 *  2. Duplicated with winning bonus    Fail
 *  3. Out of range (1-45)              Fail
 */
class ValidateWinningBonusTest {

    @Test
    fun `givenValidBonusNumber_whenValidateWinningBonus_thenDoesNotThrowException`() {
        // given
        val bonusNumber = 7
        val winningNumbers = listOf(1, 2, 3, 4, 5, 45)

        // when
        val validator = ValidateWinningBonus()

        // then
        assertDoesNotThrow {
            validator.validate(bonusNumber, winningNumbers)
        }
    }

    @Test
    fun `givenDuplicatedBonusNumber_whenValidateWinningBonus_thenThrowsException`() {
        // given
        val bonusNumber = 1
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        // when
        val validator = ValidateWinningBonus()

        // then
        val exception = assertThrows<IllegalArgumentException> {
            validator.validate(bonusNumber, winningNumbers)
        }
        assertEquals("[ERROR] Bonus number must not duplicate a winning number.", exception.message)
    }

    @Test
    fun `givenBonusNumberOutOfRange_whenValidateWinningBonus_thenThrowsException`() {
        // given(1),(2)
        val bonusNumber1 = 0
        val bonusNumber2 = 46
        val winningNumbers = listOf(1, 2, 3, 4, 5, 45)

        // when
        val validator = ValidateWinningBonus()

        // then(1),(2)
        val exception1 = assertThrows<IllegalArgumentException> {
            validator.validate(bonusNumber1, winningNumbers)
        }
        val exception2 = assertThrows<IllegalArgumentException> {
            validator.validate(bonusNumber2, winningNumbers)
        }
        assertEquals("[ERROR] Bonus number must be between 1 and 45.", exception1.message)
        assertEquals("[ERROR] Bonus number must be between 1 and 45.", exception2.message)
    }
}