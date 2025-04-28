package lotto.views

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class InputViewTest {
    @Test
    fun `valid purchase amount divisible by 1000`() {
        val validAmount = 5000
        assertEquals(validAmount, InputView.validatePurchaseAmount(validAmount))
    }

    @Test
    fun `invalid purchase amount not divisible by 1000`() {
        val invalidAmount = 1500
        assertThrows<IllegalArgumentException> {
            InputView.validatePurchaseAmount(invalidAmount)
        }
    }

    @Test
    fun `invalid purchase amount less than or equal to 0`() {
        val invalidAmount = 0
        assertThrows<IllegalArgumentException> {
            InputView.validatePurchaseAmount(invalidAmount)
        }
    }

    @Test
    fun `parse winning numbers from string`() {
        val input = "1,2,3,4,5,6"
        val expected = listOf(1, 2, 3, 4, 5, 6)
        assertEquals(expected, InputView.parseWinningNumbers(input))
    }

    @Test
    fun `validate that the length of winning numbers is 6`() {
        val invalidNumbers = listOf(1, 2, 3, 4, 5)
        assertThrows<IllegalArgumentException> {
            InputView.validateWinningNumbers(invalidNumbers)
        }
    }

    @Test
    fun `validate that there are no duplicate winning numbers`() {
        val invalidNumbers = listOf(1, 2, 3, 4, 5, 5)
        assertThrows<IllegalArgumentException> {
            InputView.validateWinningNumbers(invalidNumbers)
        }
    }

    @Test
    fun `validate if winning numbers are out of range or not`() {
        val invalidNumbers = listOf(1, 2, 3, 4, 5, 46)
        assertThrows<IllegalArgumentException> {
            InputView.validateWinningNumbers(invalidNumbers)
        }
    }

    @Test
    fun `validate valid bonus number`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        assertEquals(bonusNumber, InputView.validateBonusNumber(winningNumbers, bonusNumber))
    }

    @Test
    fun `validate duplicate bonus number`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 6
        assertThrows<IllegalArgumentException> {
            InputView.validateBonusNumber(winningNumbers, bonusNumber)
        }
    }

    @Test
    fun `validate if bonus number is out of range or not`() {
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 46
        assertThrows<IllegalArgumentException> {
            InputView.validateBonusNumber(winningNumbers, bonusNumber)
        }
    }
}
