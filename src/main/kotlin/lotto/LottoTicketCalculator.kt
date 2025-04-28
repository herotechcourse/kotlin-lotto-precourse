package lotto

object LottoTicketCalculator {
    fun calculateTicketAmount(purchaseAmount: Int): Int {
        return purchaseAmount / 1000
    }
}