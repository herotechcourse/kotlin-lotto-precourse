package lotto.data.repo

import lotto.Lotto
import lotto.data.service.LottoNumberService
import lotto.domain.model.WinningNumbers
import lotto.domain.repo.LottoRepository

class LottoRepositoryImpl(val lottoNumberService: LottoNumberService) : LottoRepository {
  private lateinit var generatedTickets: List<Lotto>

  override fun generateLottoTickets(purchaseAmount: Int): List<Lotto> {
    val numberOfTickets = purchaseAmount / 1000
    val tickets = List(numberOfTickets) {
      Lotto(lottoNumberService.generate())
    }
    saveLottoTickets(tickets)
    return tickets
  }
  override fun saveLottoTickets(tickets: List<Lotto>) {
    generatedTickets = tickets
  }

  override fun getLottoTickets(): List<Lotto> {
    return generatedTickets
  }

}
