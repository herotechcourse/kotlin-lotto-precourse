package lotto.usecases

import lotto.Lotto
import lotto.domain.repo.LottoRepository
import lotto.domain.usecases.PurchaseLottoUseCase
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PurchaseLottoUseCaseTest {

  // Fake Repo
  class FakeLottoRepository : LottoRepository {
    override fun generateLottoTickets(purchaseAmount: Int): List<Lotto> {
      return List(purchaseAmount / 1000) { Lotto(listOf(1, 2, 3, 4, 5, 6)) }
    }

    override fun saveLottoTickets(tickets: List<Lotto>) {
      // Not needed
    }

    override fun getLottoTickets(): List<Lotto> {
      // Not needed
      return emptyList()
    }
  }

  @Test
  fun `generates correct number of lotto tickets based on purchase amount`() {
    val fakeRepository = FakeLottoRepository()
    val useCase = PurchaseLottoUseCase(fakeRepository)
    val purchaseAmount = 3000

    val tickets = useCase.run(purchaseAmount)

    assertEquals(3, tickets.size)
    tickets.forEach { lotto ->
      assertEquals(listOf(1, 2, 3, 4, 5, 6), lotto.getNumbers())
    }
  }
}
