package lotto.domain.repo

import lotto.domain.model.LottoTicket
import lotto.domain.model.WinningNumbers

interface LottoRepository {
  fun generateLottoTickets(purchaseAmount: Int): List<LottoTicket>
  fun saveLottoTickets(tickets: List<LottoTicket>)
  fun getLottoTickets(): List<LottoTicket>
  fun createWinningNumbers(mainNumbers: List<Int>, bonusNumber: Int): WinningNumbers
}
