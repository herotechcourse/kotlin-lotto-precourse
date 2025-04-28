package lotto

import lotto.domain.LottoMachine
import lotto.view.InputView;
import lotto.view.OutputView

fun main() {
  val purchaseAmount = InputView.readPurchaseAmount();
  val count = purchaseAmount/1000
  val tickets = LottoMachine().issu(count)
  OutputView.printTickets(tickets)

  val winningNumbers = InputView.readWinningNumbers()
  val bonusNumber = InputView.readBonusNumber(winningNumbers)
}
