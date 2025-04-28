package lotto.domain.repo

import lotto.Lotto
import lotto.domain.model.WinningNumbers

interface LottoRepository {
  fun generateLottoTickets(purchaseAmount: Int): List<Lotto>
  fun saveLottoTickets(tickets: List<Lotto>)
  fun getLottoTickets(): List<Lotto>
}
