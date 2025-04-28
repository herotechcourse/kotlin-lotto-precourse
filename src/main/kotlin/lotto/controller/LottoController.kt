package lotto.controller

import lotto.Lotto
import lotto.domain.InputValidator
import lotto.domain.LottoResultChecker
import lotto.domain.LottoTicketIssuer
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
        private val inputView: InputView,
        private val outputView: OutputView,
        private val lottoTicketIssuer: LottoTicketIssuer,
        private val lottoResultChecker: LottoResultChecker
) {
    fun run() {
        val purchaseAmount = getValidPurchaseAmount()
        val lottoNumbers = getValidLottoNumbers()
        val bonusNumber = getValidBonusNumber(lottoNumbers)

        val tickets = lottoTicketIssuer.issueLottoTickets(purchaseAmount)
        outputView.printLottoTickets(tickets)

        val lottoResult = lottoResultChecker.checkLottoResults(tickets, lottoNumbers, bonusNumber)
        outputView.printWinningStatistics(lottoResult)

        val totalPrize = lottoResultChecker.calculateTotalPrize(lottoResult)
        val profitRate = lottoResultChecker.getProfitRate(totalPrize, purchaseAmount)
        outputView.printTotalEarnings(profitRate)
    }

    private fun getValidPurchaseAmount(): Int {
        while (true) {
            try {
                val purchaseAmount = inputView.readPurchaseAmount()
                return InputValidator.parseAndValidatePurchaseAmount(purchaseAmount)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getValidLottoNumbers(): Lotto {
        while (true) {
            try {
                val lottoNumbers = inputView.readLottoNumbers()
                return InputValidator.parseAndValidateLottoNumbers(lottoNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getValidBonusNumber(winningLotto: Lotto): Int {
        while (true) {
            try {
                val bonusNumber = inputView.readBonusNumber()
                return InputValidator.parseAndValidateBonusNumber(bonusNumber, winningLotto)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}
