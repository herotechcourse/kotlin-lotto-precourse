package lotto.controller

import lotto.view.*
import lotto.domain.*
import lotto.service.*

class LottoController {
    private val service = LottoService()

    fun run() {
        val money = InputView.inputPurchaseAmount()
        val tickets = service.purchaseTickets(money)
        OutputView.printPurchasedTickets(tickets)

        val winningNumbers = InputView.inputWinningNumbers()
        val bonusNumber = InputView.inputBonusNumber(winningNumbers)

        val winningLotto = WinningLotto(winningNumbers, bonusNumber)
        val lottoResult = service.calculateResults(tickets, winningLotto)  // ✅ 수정
        val profitRate = service.calculateProfitRate(money, lottoResult)    // ✅ 수정

        OutputView.printResults(lottoResult, profitRate)                    // ✅ 수정
    }
}
