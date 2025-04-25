package lotto.controller

import lotto.Lotto
import lotto.model.LottoManager
import lotto.model.User
import lotto.model.WinnerLotto
import lotto.utils.InputValidator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {

    fun run() {
        // Input (Budget)
        val budget = readAndValidatePurchaseAmount()
        val user = User(budget)

        // Output (Purchased Tickets)
        outputView.printPurchasedTickets(user)
        outputView.printNewLine()

        // Input (Winner Lotto)
        val winnerLotto: Lotto = readAndValidateWinnerLotto()
        outputView.printNewLine()

        // Input (Bonus Number)
        val winnerLottoWithBonus: WinnerLotto = readAndValidateBonusNumberAndGetWinnerLotto(winnerLotto)
        outputView.printNewLine()


        val lottoManager = LottoManager(winnerLottoWithBonus, user)

        // Output (Winner Statistic)
        outputView.printWinningStatistics(lottoManager)

    }

    private fun readAndValidatePurchaseAmount(): Long {
        while (true) {
            try {
                val budget = inputView.readPurchaseAmount()
                val validatedBudget = InputValidator.validatePurchaseAmount((budget))
                return validatedBudget
            } catch (e: IllegalArgumentException) {
                e.message?.let { outputView.printError(it) }
                outputView.printNewLine()
            }
        }
    }

    private fun readAndValidateWinnerLotto(): Lotto {
        while (true) {
            try {
                val lottoNumbers = inputView.readWinnerLotto()
                val validatedLotto = InputValidator.validateWinnerLottoAndGetLotto(lottoNumbers)
                return validatedLotto
            } catch (e: IllegalArgumentException) {
                e.message?.let { outputView.printError(it) }
                outputView.printNewLine()

            }
        }
    }

    // hmm.. combine function..
    private fun readAndValidateBonusNumberAndGetWinnerLotto(winnerLotto: Lotto): WinnerLotto {
        while (true) {
            try {
                val bonusNumber = inputView.readBonusNumber()
                val validatedBonus = InputValidator.validateBonusNumberAndGetWinnerLotto(bonusNumber, winnerLotto)
                return validatedBonus
            } catch (e: IllegalArgumentException) {
                e.message?.let { outputView.printError(it) }
                outputView.printNewLine()
            }
        }
    }
}