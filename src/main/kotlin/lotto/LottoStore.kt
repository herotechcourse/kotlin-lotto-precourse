package lotto

class LottoStore(val lottoGenerator: LottoGenerator) {

    fun sellLottoTickets(purchaseAmount: LottoPurchaseAmount): List<Lotto> {
        val quantity = purchaseAmount.calculateQuantity()
        return List(quantity) { lottoGenerator.generate() }
    }
}
