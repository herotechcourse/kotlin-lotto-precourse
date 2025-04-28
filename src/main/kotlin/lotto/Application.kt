package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoTicket
import lotto.domain.Rank
import lotto.view.InputView
import lotto.view.OutputView



fun main() {
  val purchaseAmount = InputView.readPurchaseAmount()
  val tickets = LottoMachine().buyLottoTickets(purchaseAmount)    

  OutputView.printTickets(tickets)

  val winningNumbers = InputView.readWinningNumbers()
  val bonusNumber = InputView.readBonusNumber()

  val ranks = tickets.map { it.match(winningNumbers, bonusNumber) }
  OutputView.printResult(ranks, purchaseAmount)
}
