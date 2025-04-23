package lotto

class LottoGame {
    fun run() {
        OutputView().welcome()
        val purchaseAmount = InputView().purchaseAmount()
        val ticketCount = calculateTicketCount(purchaseAmount)
        OutputView().printPurchasedCount(ticketCount)
    }

    private fun calculateTicketCount(purchaseAmount: String) = purchaseAmount.toInt() / 1000
}