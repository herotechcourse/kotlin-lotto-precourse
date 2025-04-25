package lotto.domain.usecases

import lotto.domain.model.LottoTicket
import lotto.domain.repo.LottoRepository

class PurchaseLottoUseCase(
    private val lottoRepository: LottoRepository
) {
    fun run(purchaseAmount: Int): List<LottoTicket> {
        validateAmount(purchaseAmount)
        return lottoRepository.generateLottoTickets(purchaseAmount)
    }

    private fun validateAmount(amount: Int) {
        require(amount >= 1000) { "[ERROR] Purchase amount must be at least 1,000 KRW." }
        require(amount % 1000 == 0) { "[ERROR] Amount must be divisible by 1,000." }
    }
}
