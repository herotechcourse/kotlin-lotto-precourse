package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoResult
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()
    val ticketCount = purchaseAmount / 1000
    val tickets = LottoMachine.generateTickets(ticketCount)

    OutputView.printPurchasedTickets(tickets)

    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber()

    val result = LottoResult.evaluate(tickets, winningNumbers, bonusNumber)
    OutputView.printStatistics(result, purchaseAmount)
}
