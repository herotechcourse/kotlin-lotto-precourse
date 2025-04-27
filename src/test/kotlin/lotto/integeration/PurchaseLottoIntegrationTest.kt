package lotto.integeration

import lotto.Lotto
import lotto.domain.repo.LottoRepository
import lotto.domain.usecases.PurchaseLottoUseCase
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PurchaseLottoIntegrationTest {

    class FakeLottoRepository : LottoRepository {
        private val savedTickets = mutableListOf<Lotto>()

        override fun generateLottoTickets(purchaseAmount: Int): List<Lotto> {
            val tickets = List(purchaseAmount / 1000) { Lotto(listOf(1, 2, 3, 4, 5, 6)) }
            savedTickets.addAll(tickets)
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
    fun `purchasing lotto tickets saves correct number of tickets`() {
        val fakeRepo = FakeLottoRepository()
        val purchaseUseCase = PurchaseLottoUseCase(fakeRepo)

        val tickets = purchaseUseCase.run(3000)

        assertEquals(3, tickets.size)
        assertEquals(3, fakeRepo.getLottoTickets().size)
    }
}
