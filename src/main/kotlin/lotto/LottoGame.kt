package lotto

class LottoGame {
    fun run() {
        OutputView().welcome()
        val purchaseAmount = InputView().purchaseAmount()
        val ticketCount = calculateTicketCount(purchaseAmount)
        OutputView().printPurchasedCount(ticketCount)
        val lottos = LottoMachine().generate(ticketCount)
    }

    private fun calculateTicketCount(purchaseAmount: String) = purchaseAmount.toInt() / LOTTO_PRICE

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}