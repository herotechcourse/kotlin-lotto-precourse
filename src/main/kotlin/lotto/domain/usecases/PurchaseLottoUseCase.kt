package lotto.domain.usecases

import lotto.domain.model.LottoTicket
import lotto.domain.repo.LottoRepository

class PurchaseLottoUseCase(
    private val lottoRepository: LottoRepository
) {
    fun run(purchaseAmount: Int): List<LottoTicket> {
        return lottoRepository.generateLottoTickets(purchaseAmount)
    }


}
