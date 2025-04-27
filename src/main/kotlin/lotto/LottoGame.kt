package lotto

class LottoGame {
    fun run() {
        val purchaseAmount = inputPurchaseAmount()
        val lottos = generateLottos(purchaseAmount)
        val winningLotto = inputWinningLotto()

        val result = calculateResult(winningLotto, lottos, purchaseAmount)
        printResult(result)
    }

    private fun printResult(result: Result) {
        OutputView().printWinningStatics()
        println(result)
    }

    private fun calculateResult(
        winningLotto: WinningLotto,
        lottos: Lottos,
        purchaseAmount: String
    ): Result {
        return Result().apply { calculateResult(winningLotto, lottos, purchaseAmount) }
    }

    private fun inputWinningLotto(): WinningLotto {
        OutputView().askWinningNumbers()
        val lastWeekWinningNumbers = InputView().lastWeekWinningNumbers()

        OutputView().askBonusNumber()
        val lastWeekBonusNumber = InputView().lastWeekBonusNumber(lastWeekWinningNumbers)

        return WinningLotto().apply {
            registerWinningNumbers(lastWeekWinningNumbers)
            registerBonusNumber(lastWeekBonusNumber)
        }
    }

    private fun generateLottos(purchaseAmount: String): Lottos {
        val ticketCount = calculateTicketCount(purchaseAmount)
        OutputView().printPurchasedCount(ticketCount)
        val lottos = LottoMachine().generate(ticketCount)
        OutputView().printLottos(lottos)
        return lottos
    }

    private fun inputPurchaseAmount(): String {
        OutputView().askPurchaseAmount()
        return InputView().purchaseAmount()
    }

    private fun calculateTicketCount(purchaseAmount: String): Int {
        return purchaseAmount.toInt() / LOTTO_PRICE
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}