package lotto

fun runLotto(inputView: InputView, outputView: OutputView) {
    // get purchase amount and show the tickets
    val purchaseAmount = inputView.readPurchaseAmount()
    val tickets = LottoFactory.createMultipleTickets(purchaseAmount)
    outputView.printTickets(tickets)
    // get winning numbers and bonus number
    val winningNumbers = inputView.readWinningNumbers()
    val bonusNumber = inputView.readBonusNumber(winningNumbers)
    // show the result
    val lottoMatcher = LottoMatcher(winningNumbers, bonusNumber)
    val result = lottoMatcher.calculatePrizeResult(tickets)
    outputView.printResult(result)
}

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    runLotto(inputView, outputView)
}
