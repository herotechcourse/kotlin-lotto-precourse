package lotto

class LottoGame {
    fun run() {
        OutputView().askPurchaseAmount()
        val purchaseAmount = InputView().purchaseAmount()
        val ticketCount = calculateTicketCount(purchaseAmount)
        OutputView().printPurchasedCount(ticketCount)
        val lottos = LottoMachine().generate(ticketCount)
        OutputView().printLottos(lottos)
        OutputView().askWinningNumbers()
        val lastWeekWinningNumbers = InputView().lastWeekWinningNumbers()
        val splittedWinningNumbers = Util().winningNumberSplitter(lastWeekWinningNumbers)
        val winningLotto = WinningLotto()
        winningLotto.registerWinningNumbers(splittedWinningNumbers)
        OutputView().askBonusNumber()
        val lastWeekBonusNumber = InputView().lastWeekBonusNumber()
        winningLotto.registerBonusNumber(lastWeekBonusNumber)

        OutputView().printWinningStatics()
    }

    private fun calculateTicketCount(purchaseAmount: String) = purchaseAmount.toInt() / LOTTO_PRICE

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}