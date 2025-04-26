package lotto

fun main() {
    try {
        val purchaseAmount = InputView.promptPurchaseAmount()
        val tickets = LottoMachine.generateTickets(purchaseAmount)
        OutputView.displayTickets(tickets)

        val (winningNumbers, bonusNumber) = InputView.promptWinningNumbers()
        val lottoResult = LottoMachine.calculateResults(tickets, winningNumbers, bonusNumber)
        OutputView.displayResults(lottoResult)
    } catch (e: IllegalArgumentException) {
        println("[ERROR] ${e.message}")
    }
}
