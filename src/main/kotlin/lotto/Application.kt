package lotto

import lotto.view.InputView
import lotto.view.OutputView

fun main() {
  try {
    val purchaseAmount = InputView.readPurchaseAmount()
    val tickets = TicketMachine.issueTickets(purchaseAmount)

    // Print tickets
    OutputView.printTickets(tickets)

    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber()

    // Calculate and print results
    val result = WinningResult.calculate(tickets, winningNumbers, bonusNumber)
    OutputView.printResult(result, purchaseAmount)
  } catch (e: IllegalArgumentException) {
    println(e.message)
  }
}
