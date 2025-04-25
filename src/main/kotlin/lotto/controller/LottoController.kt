package lotto.controller

import lotto.Lotto
import lotto.model.LottoManager
import lotto.model.User
import lotto.utils.InputValidator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val inputValidator: InputValidator,
) {

    fun run() {
        // Input (Budget)
        val budget = readAndValidatePurchaseAmount()
        val user = User(budget)

        // Output (Purchased Tickets)
        outputView.printPurchasedTickets(user)
        outputView.printNewLine()

        // Input (Winner Lotto)
        val winnerLotto = readAndValidateWinnerLotto()
        outputView.printNewLine()

        // Input (Bonus Number)
        val winnerBonusNumber = readAndValidateBonusNumber(winnerLotto)
        winnerLotto.bonusNumber = winnerBonusNumber
        outputView.printNewLine()


        val lottoManager = LottoManager(winnerLotto, user)

        // Output (Winner Statistic)
        outputView.printWinningStatistics(lottoManager)

    }

    private fun readAndValidatePurchaseAmount(): Long {
        while (true) {
            try {
                val budget = inputView.readPurchaseAmount()
                val validatedBudget = inputValidator.validatePurchaseAmount((budget))
                return validatedBudget
            } catch(e: Exception) {
                e.message?.let { outputView.printError(it) }
                outputView.printNewLine()
            }
        }
    }
    private fun readAndValidateWinnerLotto(): Lotto {
        while (true) {
            try {
                val lottoNumbers = inputView.readWinnerLotto()
                val validatedLotto = inputValidator.validateWinnerLotto(lottoNumbers)
                return validatedLotto
            } catch(e: Exception) {
                e.message?.let { outputView.printError(it) }
                outputView.printNewLine()

            }
        }
    }
    private fun readAndValidateBonusNumber(winnerLotto: Lotto): Int {
        while (true) {
            try {
                val bonusNumber = inputView.readBonusNumber()
                val validatedBonus = inputValidator.validateBonusNumber(bonusNumber, winnerLotto)
                return validatedBonus
            } catch(e: Exception) {
                e.message?.let { outputView.printError(it) }
                outputView.printNewLine()
            }
        }
    }
}