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
        InputView().lastWeekWinningNumbers()
    }

    private fun calculateTicketCount(purchaseAmount: String) = purchaseAmount.toInt() / LOTTO_PRICE

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}