package lotto

fun runLotto(inputView: InputView, outputView: OutputView) {
    val purchaseAmount = inputView.readPurchaseAmount()
    val tickets = LottoFactory.createMultipleTickets(purchaseAmount)
    outputView.printTickets(tickets)
    val winningNumbers = inputView.readWinningNumbers()
    val bonusNumber = inputView.readBonusNumber(winningNumbers)
    val lottoMatcher = LottoMatcher(winningNumbers, bonusNumber)
    val result = lottoMatcher.calculatePrizeResult(tickets)
    outputView.printResult(result)
}

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    runLotto(inputView, outputView)
}
