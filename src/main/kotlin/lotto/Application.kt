package lotto

fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()
    val lottoTickets = LottoTickets.generate(purchaseAmount)

    OutputView.printPurchasedTickets(lottoTickets)

    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber()

    val result = LottoResult.calculate(lottoTickets, winningNumbers, bonusNumber)

    OutputView.printResult(result)
}
