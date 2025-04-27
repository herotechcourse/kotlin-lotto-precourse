package lotto.controller

import lotto.view.InputView
import lotto.view.OutputView
import lotto.domain.WinningLotto
import lotto.service.LottoService

class LottoController {
    private val service = LottoService()

    fun run() {
        val money = InputView.inputPurchaseAmount()
        val tickets = service.purchaseTickets(money)
        OutputView.printPurchasedTickets(tickets)

        val winningNumbers = InputView.inputWinningNumbers()
        val bonusNumber = InputView.inputBonusNumber(winningNumbers)

        val winningLotto = WinningLotto(winningNumbers, bonusNumber)
        val lottoResult = service.calculateResults(tickets, winningLotto)
        val profitRate = service.calculateProfitRate(money, lottoResult)

        OutputView.printResults(lottoResult, profitRate)
    }
}
