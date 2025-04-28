package lotto

fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()
    val lottoMachine = LottoMachine()
    val tickets = lottoMachine.generateTickets(purchaseAmount)

    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber(winningNumbers)
    val winningNumbersObj = WinningNumbers(winningNumbers, bonusNumber)

    OutputView.printPurchasedTickets(tickets)

    val resultCalculator = ResultCalculator()
    val results = resultCalculator.calculateResults(tickets, winningNumbersObj)

    OutputView.printResultStatistics(results)

    val profitRate = resultCalculator.calculateProfitRate(results, purchaseAmount)
    OutputView.printProfitRate(profitRate)
}
