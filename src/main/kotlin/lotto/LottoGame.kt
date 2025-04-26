package lotto

class LottoGame {
    fun run() { // Todo - method separate
        OutputView().askPurchaseAmount()
        val purchaseAmount = InputView().purchaseAmount()
        val ticketCount = calculateTicketCount(purchaseAmount)
        OutputView().printPurchasedCount(ticketCount)
        val lottos = LottoMachine().generate(ticketCount)
        OutputView().printLottos(lottos)

        OutputView().askWinningNumbers()
        val lastWeekWinningNumbers = InputView().lastWeekWinningNumbers()

        val winningLotto = WinningLotto()
        winningLotto.registerWinningNumbers(lastWeekWinningNumbers)
        OutputView().askBonusNumber()
        val lastWeekBonusNumber = InputView().lastWeekBonusNumber()
        winningLotto.registerBonusNumber(lastWeekBonusNumber)

        OutputView().printWinningStatics()
        val result = Result()
        result.calculateResult(winningLotto, lottos, purchaseAmount)
        println(result)
    }

        private fun calculateTicketCount(purchaseAmount: String): Int {
            return purchaseAmount.toInt() / LOTTO_PRICE
        }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}