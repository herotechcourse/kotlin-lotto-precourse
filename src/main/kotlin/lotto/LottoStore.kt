package lotto

import lotto.lottogenerator.LottoGenerator

class LottoStore(val lottoGenerator: LottoGenerator) {

    fun issueLottoTickets(purchaseAmount: LottoPurchaseAmount): List<Lotto> {
        val quantity = computeTicketQuantity(purchaseAmount)
        return List(quantity) { lottoGenerator.generate() }
    }

    private fun computeTicketQuantity(purchaseAmount: LottoPurchaseAmount): Int {
        return purchaseAmount.value / TICKET_PRICE
    }

    companion object {
        private const val TICKET_PRICE: Int = 1_000
    }
}
