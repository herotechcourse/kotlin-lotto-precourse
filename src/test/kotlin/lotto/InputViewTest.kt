package lotto

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

class InputViewTest {

    @Test
    fun `readPurchaseAmount returns list of Lottos for valid input`() {
        val inputView = InputView(readLine = { "3000" })
        val lottos = inputView.readPurchaseAmount()
        assertEquals(3, lottos.size)
    }

    @Test
    fun `readPurchaseAmount throws exception for invalid input`() {
        val inputView = InputView(readLine = { "abc" })
        val exception = assertThrows<IllegalArgumentException> {
            inputView.readPurchaseAmount()
        }
        assertEquals(ExceptionMessage.INVALID_PURCHASE_FORMAT.message, exception.message)
    }

    @Test
    fun `getWinningNumbers returns list of 6 numbers`() {
        val inputView = InputView(readLine = { "1,2,3,4,5,6" })
        val numbers = inputView.getWinningNumbers()
        assertEquals(listOf(1, 2, 3, 4, 5, 6), numbers)
    }

    @Test
    fun `getWinningNumbers throws exception for wrong size`() {
        val inputView = InputView(readLine = { "1,2,3,4,5" })
        val exception = assertThrows<IllegalArgumentException> {
            inputView.getWinningNumbers()
        }
        assertEquals(ExceptionMessage.INVALID_WINNING_LOTTO_SIZE.message, exception.message)
    }

    @Test
    fun `getWinningNumbers throws exception for invalid format`() {
        val inputView = InputView(readLine = { "1,2,a,4,5,6" })
        val exception = assertThrows<IllegalArgumentException> {
            inputView.getWinningNumbers()
        }
        assertEquals(ExceptionMessage.INVALID_WINNING_NUMBER_FORMAT.message, exception.message)
    }

    @Test
    fun `getBonusNumber returns valid bonus number`() {
        val inputView = InputView(readLine = { "7" })
        val bonus = inputView.getBonusNumber()
        assertEquals(7, bonus)
    }

    @Test
    fun `getBonusNumber throws exception for invalid format`() {
        val inputView = InputView(readLine = { "abc" })
        val exception = assertThrows<IllegalArgumentException> {
            inputView.getBonusNumber()
        }
        assertEquals(ExceptionMessage.INVALID_BONUS_FORMAT.message, exception.message)
    }

    @Test
    fun `getBonusNumber throws exception for out of range bonus`() {
        val inputView = InputView(readLine = { "50" })
        val exception = assertThrows<IllegalArgumentException> {
            inputView.getBonusNumber()
        }
        assertEquals(ExceptionMessage.INVALID_BONUS_RANGE.message, exception.message)
    }
}
