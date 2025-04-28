package lotto.integeration

import lotto.Lotto
import lotto.domain.model.WinningNumbers
import lotto.domain.repo.LottoRepository
import lotto.domain.usecases.CalculateResultUseCase
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import lotto.domain.model.Rank

class CalculateResultIntegrationTest {

  class FakeLottoRepository(val tickets: List<Lotto>) : LottoRepository {


    override fun generateLottoTickets(purchaseAmount: Int): List<Lotto> {
      return tickets
    }

    override fun saveLottoTickets(tickets: List<Lotto>) {

    }

    override fun getLottoTickets(): List<Lotto> {
  return tickets
      }
  }


    @Test
    fun `calculates correct ranks for saved tickets based on winning numbers`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),  // First
            Lotto(listOf(1, 2, 3, 4, 5, 7)),  // Second
            Lotto(listOf(1, 2, 3, 4, 7, 8)),  // Fourth
            Lotto(listOf(1, 2, 3, 7, 8, 9))   // Fifth
        )
        val fakeRepo = FakeLottoRepository(tickets)
        val useCase = CalculateResultUseCase(fakeRepo)

        val winningNumbers = WinningNumbers(
            listOf(1, 2, 3, 4, 5, 6),
            7
        )

        val ranks = useCase.run(winningNumbers)

        assertEquals(Rank.FIRST, ranks[0])
        assertEquals(Rank.SECOND, ranks[1])
        assertEquals(Rank.FOURTH, ranks[2])
        assertEquals(Rank.FIFTH, ranks[3])
    }
}
