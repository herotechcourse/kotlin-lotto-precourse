package lotto

fun main() {
  Application().run()
}

class Application {
  fun run() {
    val purchaseAmount = InputView.readPurchaseAmount()
    val ticketCount = purchaseAmount / 1000
    val lottoTickets = LottoMachine.issueTickets(ticketCount)
    OutputView.printTickets(lottoTickets)

    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber(winningNumbers)

    val result = LottoResult(lottoTickets, winningNumbers, bonusNumber)
    OutputView.printResult(result, purchaseAmount)
  }
}
