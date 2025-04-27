package lotto

fun main() {
  val purchaseAmount = retryInput { InputView.readPurchaseAmount() }
  val ticketCount = purchaseAmount / 1000
  val tickets = LottoMachine.generateTickets(ticketCount)
  OutputView.printPurchasedTickets(tickets)

  val winningNumbers = retryInput { InputView.readWinningNumbers() }
  val bonus = retryInput { InputView.readBonusNumber(winningNumbers) }

  val statistics = LottoMachine.evaluateTickets(tickets, winningNumbers, bonus)
  OutputView.printStatistics(statistics)
  val profit = LottoMachine.calculateProfit(statistics, purchaseAmount)
  OutputView.printProfitRate(profit)
}

private fun <T> retryInput(block: () -> T): T {
  while (true) {
    try {
      return block()
    } catch (e: IllegalArgumentException) {
      OutputView.printError(e.message ?: "Invalid input.")
    } catch (e: IllegalStateException) {
      OutputView.printError(e.message ?: "Invalid state.")
    }
  }
}
