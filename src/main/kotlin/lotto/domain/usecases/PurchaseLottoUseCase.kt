package lotto.domain.usecases

import lotto.Lotto
import lotto.domain.repo.LottoRepository

class PurchaseLottoUseCase(
    private val lottoRepository: LottoRepository
) {
    fun run(purchaseAmount: Int): List<Lotto> {

        return lottoRepository.generateLottoTickets(purchaseAmount)
    }


}
