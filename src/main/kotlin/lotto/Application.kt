package lotto

import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val service = LottoService()

    val amount = InputView.requestPurchaseAmount()
    val tickets = service.generateTickets(amount)

    OutputView.printLottoTickets(tickets)

    val winningNumbers = InputView.requestWinningNumbers()
    val bonusNumber = InputView.requestBonusNumber()

    val result = service.evaluateResults(tickets, winningNumbers, bonusNumber)
    OutputView.printResults(result)

    val profitRate = service.calculateProfitRate(amount, result)
    OutputView.printProfitRate(profitRate)
}

