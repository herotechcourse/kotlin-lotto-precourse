package lotto.integeration

import lotto.Lotto
import lotto.domain.model.Rank
import lotto.domain.model.WinningNumbers
import lotto.domain.repo.LottoRepository
import lotto.domain.usecases.CalculateResultUseCase
import lotto.domain.usecases.ComputeProfitUseCase
import lotto.domain.usecases.PurchaseLottoUseCase
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FullGameFlowIntegrationTest {

    class FakeLottoRepository : LottoRepository {
        private val savedTickets = mutableListOf<Lotto>()

        override fun generateLottoTickets(purchaseAmount: Int): List<Lotto> {
            val tickets = List(purchaseAmount / 1000) { Lotto(listOf(1, 2, 3, 4, 5, 6)) }
            saveLottoTickets(tickets)
            return tickets
        }

        override fun saveLottoTickets(tickets: List<Lotto>) {
            savedTickets.addAll(tickets)
        }

        override fun getLottoTickets(): List<Lotto> {
            return savedTickets
        }
    }

  @Test
  fun `full game simulation - from purchase to final profit rate`() {
    val repository = FakeLottoRepository()

    val purchaseUseCase = PurchaseLottoUseCase(repository)
    val calculateResultUseCase = CalculateResultUseCase(repository)
    val computeProfitUseCase = ComputeProfitUseCase()

    val purchaseAmount = 3000
    val tickets = purchaseUseCase.run(purchaseAmount)

    val winningNumbers = WinningNumbers(
      listOf(1, 2, 3, 4, 5, 6),
      7
    )

    val ranks = calculateResultUseCase.run(winningNumbers)

    assertEquals(tickets.size, ranks.size)
    ranks.forEach { assertEquals(Rank.FIRST, it) }

    val profitRate = computeProfitUseCase.run(ranks, purchaseAmount)

    val expectedProfitRate = ((Rank.FIRST.prize * tickets.size).toDouble() / purchaseAmount) * 100
    assertEquals(expectedProfitRate, profitRate)
  }

}
