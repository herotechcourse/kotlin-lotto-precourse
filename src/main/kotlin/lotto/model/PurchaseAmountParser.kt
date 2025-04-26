package lotto.model

object PurchaseAmountParser {
    fun parse(purchaseAmount: Int): Int {
        val ticketCount = purchaseAmount / 1000

        return ticketCount
    }
}
