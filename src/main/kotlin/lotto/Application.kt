package lotto

fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()

    val lottos = LottoService.generateLottos(purchaseAmount)
    OutputView.printLottos(lottos)

    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber(winningNumbers)

    val result = ResultService.calculateResult(lottos, winningNumbers, bonusNumber)
    OutputView.printResult(result)

    val profitRate = ResultService.calculateProfitRate(result, purchaseAmount)
    OutputView.printProfitRate(profitRate)
}
