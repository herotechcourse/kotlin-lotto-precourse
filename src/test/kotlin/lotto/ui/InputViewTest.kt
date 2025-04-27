package lotto.ui

import lotto.Lotto
import lotto.util.Constants
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class InputViewTest {
    @Test
    fun `getPurchaseAmount should return valid amount when input is valid`() {
        val testIO = TestConsoleIO(mutableListOf("5000"))
        val inputView = InputView(testIO)
        val amount = inputView.getPurchaseAmount()
        assertThat(amount).isEqualTo(5000)
    }

    @Test
    fun `Re-prompt when input is non-numeric in getPurchaseAmount`() {
        val testIO = TestConsoleIO(mutableListOf("abcd", "5000"))
        val inputView = InputView(testIO)
        val amount = inputView.getPurchaseAmount()

        assertThat(testIO.outputMessages[0]).isEqualTo(Constants.PURCHASE_AMOUNT_PROMPT)
        assertThat(testIO.outputMessages[1]).isEqualTo(Constants.ERROR_INVALID_NUMBER)
        assertThat(testIO.outputMessages[2]).isEqualTo(Constants.PURCHASE_AMOUNT_PROMPT)
        assertThat(amount).isEqualTo(5000)
    }

    @Test
    fun `Re-prompts when input is less than the minimum purchase amount in getPurchaseAmount`() {
        val testIO = TestConsoleIO(mutableListOf("500", "5000"))
        val inputView = InputView(testIO)
        val amount = inputView.getPurchaseAmount()

        assertThat(testIO.outputMessages[0]).isEqualTo(Constants.PURCHASE_AMOUNT_PROMPT)
        assertThat(testIO.outputMessages[1]).isEqualTo(Constants.ERROR_INVALID_PURCHASE_AMOUNT)
        assertThat(testIO.outputMessages[2]).isEqualTo(Constants.PURCHASE_AMOUNT_PROMPT)
        assertThat(amount).isEqualTo(5000)
    }

    @Test
    fun `Re-prompts when input can't divide by purchase amount unit in getPurchaseAmount`() {
        val testIO = TestConsoleIO(mutableListOf("1500", "5000"))
        val inputView = InputView(testIO)
        val amount = inputView.getPurchaseAmount()

        assertThat(testIO.outputMessages[0]).isEqualTo(Constants.PURCHASE_AMOUNT_PROMPT)
        assertThat(testIO.outputMessages[1]).isEqualTo(Constants.ERROR_INVALID_PURCHASE_UNIT)
        assertThat(testIO.outputMessages[2]).isEqualTo(Constants.PURCHASE_AMOUNT_PROMPT)
        assertThat(amount).isEqualTo(5000)
    }

    @Test
    fun `getWinningNumbers should return a Lotto object when input is valid`() {
        val testIO = TestConsoleIO(mutableListOf("1,2,3,4,5,6"))
        val inputView = InputView(testIO)
        val winningLotto = inputView.getWinningNumbers()
        assertThat(winningLotto).isEqualTo(Lotto(listOf(1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun `Re-prompt when input contains non-numeric in getWinningNumbers`() {
        val testIO = TestConsoleIO(mutableListOf("1,2,a,4,5,6", "1,2,3,4,5,6"))
        val inputView = InputView(testIO)
        val winningLotto = inputView.getWinningNumbers()

        assertThat(testIO.outputMessages[0]).isEqualTo(Constants.WINNING_NUMBERS_PROMPT)
        assertThat(testIO.outputMessages[1]).isEqualTo(Constants.ERROR_INVALID_WINNING_NUMBER)
        assertThat(testIO.outputMessages[2]).isEqualTo(Constants.WINNING_NUMBERS_PROMPT)
        assertThat(winningLotto).isEqualTo(Lotto(listOf(1, 2, 3, 4, 5, 6)))
    }

    @Test
    fun `getBonusNumber should return a valid bonus number when input is valid`() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val testIO = TestConsoleIO(mutableListOf("7"))
        val inputView = InputView(testIO)
        val bonusNumber = inputView.getBonusNumber(winningLotto)
        assertThat(bonusNumber).isEqualTo(7)
    }

    @Test
    fun `Re-prompt when input is non-numeric in getBonusNumber`() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val testIO = TestConsoleIO(mutableListOf("abcd", "7"))
        val inputView = InputView(testIO)
        val bonusNumber = inputView.getBonusNumber(winningLotto)

        assertThat(testIO.outputMessages[0]).isEqualTo(Constants.BONUS_NUMBER_PROMPT)
        assertThat(testIO.outputMessages[1]).isEqualTo(Constants.ERROR_INVALID_BONUS_NUMBER)
        assertThat(testIO.outputMessages[2]).isEqualTo(Constants.BONUS_NUMBER_PROMPT)
        assertThat(bonusNumber).isEqualTo(7)
    }

    @Test
    fun `Re-prompt when bonus number is less than 1 in getBonusNumber`() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val testIO = TestConsoleIO(mutableListOf("-1", "7"))
        val inputView = InputView(testIO)
        val bonusNumber = inputView.getBonusNumber(winningLotto)

        assertThat(testIO.outputMessages[0]).isEqualTo(Constants.BONUS_NUMBER_PROMPT)
        assertThat(testIO.outputMessages[1]).isEqualTo(Constants.ERROR_BONUS_OUT_OF_RANGE)
        assertThat(testIO.outputMessages[2]).isEqualTo(Constants.BONUS_NUMBER_PROMPT)
        assertThat(bonusNumber).isEqualTo(7)
    }

    @Test
    fun `Re-prompt when bonus number is greater than 45 in getBonusNumber`() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val testIO = TestConsoleIO(mutableListOf("46", "7"))
        val inputView = InputView(testIO)
        val bonusNumber = inputView.getBonusNumber(winningLotto)

        assertThat(testIO.outputMessages[0]).isEqualTo(Constants.BONUS_NUMBER_PROMPT)
        assertThat(testIO.outputMessages[1]).isEqualTo(Constants.ERROR_BONUS_OUT_OF_RANGE)
        assertThat(testIO.outputMessages[2]).isEqualTo(Constants.BONUS_NUMBER_PROMPT)
        assertThat(bonusNumber).isEqualTo(7)
    }

    @Test
    fun `Re-prompt when bonus number is a duplicate of winning numbers in getBonusNumber`() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val testIO = TestConsoleIO(mutableListOf("3", "7"))
        val inputView = InputView(testIO)
        val bonusNumber = inputView.getBonusNumber(winningLotto)

        assertThat(testIO.outputMessages[0]).isEqualTo(Constants.BONUS_NUMBER_PROMPT)
        assertThat(testIO.outputMessages[1]).isEqualTo(Constants.ERROR_DUPLICATE_BONUS_NUMBER)
        assertThat(testIO.outputMessages[2]).isEqualTo(Constants.BONUS_NUMBER_PROMPT)
        assertThat(bonusNumber).isEqualTo(7)
    }
}
