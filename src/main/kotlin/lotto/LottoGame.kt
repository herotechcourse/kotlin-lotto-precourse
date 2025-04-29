package lotto

import lotto.view.InputView
import lotto.view.OutputView
import lotto.domain.*

class LottoGame {
  fun run() {
    val amount = InputView.readPurchaseAmount()
    val ticketCount = amount / LottoConfig.TICKET_PRICE
    val tickets = LottoGenerator.generateTickets(ticketCount)
    OutputView.printTickets(tickets)

    val winningNumbers = InputView.readWinningNumbers()
    val bonus = InputView.readBonusNumber()
    val winningLotto = WinningLotto(winningNumbers, bonus)

    val result = ResultCalculator.calculate(tickets, winningLotto)
    OutputView.printStatistics(result, amount)
  }
}