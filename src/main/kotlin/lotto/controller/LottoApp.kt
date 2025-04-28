package lotto.controller

import lotto.model.LottoService
import lotto.view.InputView
import lotto.view.OutputView

class LottoApp(
    private val lottoService: LottoService,
    private val inputView: InputView,
    private val outputView: OutputView
) {

    fun run() {
        val purchaseAmount = inputView.readPurchaseAmount()

        handleUserInput(purchaseAmount)
        handleResultProcessing(purchaseAmount)
    }

    private fun handleUserInput(purchaseAmount: Int) {

        lottoService.purchaseTickets(purchaseAmount)
        outputView.displayPurchasedTickets(lottoService.getTickets())

        val winnerNumbers = inputView.readWinnerNumbers()
        lottoService.setWinnerNumbers(winnerNumbers)

        val bonusNumber = inputView.readBonusNumber(lottoService.getWinnerNumbers())
        lottoService.setBonusNumber(bonusNumber)
    }

    private fun handleResultProcessing(purchaseAmount: Int) {
        val rankList = lottoService.compareTickets()
        outputView.displayWinningStatistics(rankList)

        val returnRate = lottoService.calculateReturnRate(
            rankList, purchaseAmount
        )
        outputView.displayReturnRate(returnRate)
    }

}