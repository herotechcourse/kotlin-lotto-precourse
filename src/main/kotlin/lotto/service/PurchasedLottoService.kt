package lotto.service

import lotto.domain.PurchasedLotto
import lotto.repository.PurchasedLottoRepository

class PurchasedLottoService {
    val purchaseLottoRepository = PurchasedLottoRepository()

    fun generatePurchasedLottoNumbers(ticketCount: Int) {
        val purchasedLottos = PurchasedLotto.generateLottoNumbers(ticketCount)
        purchaseLottoRepository.makePurchasedLottos(purchasedLottos)
    }

    fun getAllPurchasedLottoNumbers(): List<PurchasedLotto> {
        return purchaseLottoRepository.retrievePurchasedLottos()
    }
}