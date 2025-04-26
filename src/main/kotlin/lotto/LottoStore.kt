package lotto

import lotto.lottogenerator.LottoGenerator

class LottoStore(val lottoGenerator: LottoGenerator) {

    fun issueLottoTickets(purchaseAmount: LottoPurchaseAmount): List<Lotto> {
        val quantity = purchaseAmount.calculateQuantity()
        return List(quantity) { lottoGenerator.generate() }
    }
}
