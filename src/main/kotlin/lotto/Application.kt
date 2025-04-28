package lotto

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val purchaseAmount = inputView.getPurchaseAmount()
    val tickets = LottoMachine(purchaseAmount).generateTickets()
    outputView.printTickets(tickets)

    val winningNumbers = inputView.getWinningNumbers()
    val bonusNumber = inputView.getBonusNumber()

    val lottoResult = LottoResult(tickets, winningNumbers, bonusNumber)
    val resultStatistics = lottoResult.getPrizeStatistics()
    val profitRate = lottoResult.calculateProfitRate(purchaseAmount)

    outputView.printResults(resultStatistics, profitRate)
}
