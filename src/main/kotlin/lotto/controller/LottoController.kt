package lotto.controller

import lotto.domain.BonusNumber
import lotto.domain.LottoMachine
import lotto.domain.WinningNumbers
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    fun run() {
        val lottoMachine = createLottoMachine()
        val winningNumbers = createWinningNumbers()
        val bonusNumber = createBonusNumber(winningNumbers)

        //TODO: logic for ticket generation, comparison, result display
    }

    private fun createLottoMachine(): LottoMachine {
        while (true) {
            val purchaseAmountInput = inputView.readPurchaseAmount()
            try {
                return LottoMachine(purchaseAmountInput)
            } catch (e: IllegalArgumentException) {
                outputView.displayError(e.message)
            }
        }
    }

    private fun createWinningNumbers(): WinningNumbers {
        while (true) {
            val winningNumbersInput = inputView.readWinningNumbers()
            try {
                return WinningNumbers(winningNumbersInput)
            } catch (e: IllegalArgumentException) {
                outputView.displayError(e.message)
            }
        }
    }

    private fun createBonusNumber(winningNumbers: WinningNumbers): BonusNumber {
        while (true) {
            val bonusNumberInput = inputView.readBonusNumber()
            try {
                return BonusNumber(bonusNumberInput, winningNumbers)
            } catch (e: IllegalArgumentException) {
                outputView.displayError(e.message)
            }
        }
    }

}