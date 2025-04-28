package lotto.domain.usecases

import lotto.domain.model.WinningNumbers
import lotto.domain.repo.LottoRepository
import lotto.domain.model.Rank

class CalculateResultUseCase(
  private val repository: LottoRepository
) {
  fun run(winningNumbers: WinningNumbers): List<Rank> {
    val purchasedTickets = repository.getLottoTickets()
    return purchasedTickets.map { ticket ->
      val currLottoResult = winningNumbers.match(ticket)
      Rank.from(currLottoResult)
    }
  }
}
