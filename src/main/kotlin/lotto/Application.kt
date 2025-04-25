package lotto

fun main() {
    val lottoResult = LottoResult()

    val purchaseAmount = InputView.readValidPurchaseAmount()

    val numberOfTickets = LottoMachine.getTicketCount(purchaseAmount)
    val tickets = LottoMachine.generateTickets(numberOfTickets)

    OutputView.printTickets(tickets)

    val winningNumbers = InputView.readValidWinningNumbers()
    val bonusNumber = InputView.readValidBonusNumber()

    tickets.forEach { lottoResult.evaluateAndRecord(it, winningNumbers, bonusNumber) }

    OutputView.printResults(lottoResult.getRankStatistics())
    OutputView.printProfitReturn(lottoResult.getProfitRate(purchaseAmount))
}
