package lotto

class LottoProgram {
    private val lottoService = LottoService()
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        try {
            val purchaseAmount = inputView.getPurchaseAmount()
            val lottos = lottoService.purchaseLottos(purchaseAmount)

            outputView.printPurchasedLottos(lottos)

            val winningNumbers = inputView.getWinningNumbers()
            val bonusNumber = inputView.getBonusNumber(winningNumbers)

            val results = lottoService.calculateResults(lottos, winningNumbers, bonusNumber)
            outputView.printWinningStatistics(results, purchaseAmount)

        } catch (e: IllegalArgumentException) {
            outputView.printError(e.message ?: "An error occurred")
        }
    }
}
