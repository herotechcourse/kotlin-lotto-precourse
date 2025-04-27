package lotto.usecases

import lotto.Lotto
import lotto.domain.model.Rank
import lotto.domain.model.WinningNumbers
import lotto.domain.repo.LottoRepository
import lotto.domain.usecases.CalculateResultUseCase
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalculateResultUseCaseTest {

    // Fake Repo
    class FakeLottoRepository(private val tickets: List<Lotto>) : LottoRepository {
        override fun generateLottoTickets(purchaseAmount: Int): List<Lotto> {
            // Not needed for this test
            return emptyList()
        }

        override fun saveLottoTickets(tickets: List<Lotto>) {
            // Not needed for this test
        }

        override fun getLottoTickets(): List<Lotto> {
            return tickets
        }
    }

    @Test
    fun `calculates correct ranks for purchased lotto tickets`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),  // Perfect match
            Lotto(listOf(1, 2, 3, 4, 5, 7)),  // 5 numbers + bonus
            Lotto(listOf(1, 2, 3, 4, 7, 8)),  // 4 numbers
            Lotto(listOf(1, 2, 3, 7, 8, 9))   // 3 numbers
        )
        val fakeRepository = FakeLottoRepository(tickets)
        val useCase = CalculateResultUseCase(fakeRepository)

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
