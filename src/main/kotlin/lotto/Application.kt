package lotto

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val lottoResult = LottoResult()

    val purchaseAmount = inputView.readValidPurchaseAmount()

    val numberOfTickets = LottoMachine.getTicketCount(purchaseAmount)
    val tickets = LottoMachine.generateTickets(numberOfTickets)

    outputView.printTickets(tickets)

    val winningNumbers = inputView.readValidWinningNumbers()
    val bonusNumber = inputView.readValidBonusNumber()

    tickets.forEach { lottoResult.evaluateAndRecord(it, winningNumbers, bonusNumber) }

    outputView.printResults(lottoResult.getRankStatistics())
    outputView.printProfitReturn(lottoResult.getProfitRate(purchaseAmount))
}
