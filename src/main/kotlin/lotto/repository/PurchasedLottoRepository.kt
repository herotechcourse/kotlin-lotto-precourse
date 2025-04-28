package lotto.repository

import lotto.domain.PurchasedLotto

class PurchasedLottoRepository {
    val purchasedLottos = mutableListOf<PurchasedLotto>()

    fun makePurchasedLottos(lottos: List<PurchasedLotto>) {
        purchasedLottos.addAll(lottos)
    }

    fun retrievePurchasedLottos(): List<PurchasedLotto> {
        return purchasedLottos
    }
}