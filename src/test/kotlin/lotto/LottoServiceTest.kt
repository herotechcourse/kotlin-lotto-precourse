package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoServiceTest {

    @Test
    fun `createLottoTickets should generate correct number of tickets`() {
        val lottoService = LottoService()
        assertEquals(1, lottoService.createLottoTickets(1000).size)
        assertEquals(5, lottoService.createLottoTickets(5000).size)
        assertEquals(10, lottoService.createLottoTickets(10000).size)
    }

    @ParameterizedTest
    @ValueSource(ints = [1000, 2000, 5000, 10000])
    fun `createLottoTickets should create valid lotto tickets`(amount: Int) {
        val lottoService = LottoService()
        val tickets = lottoService.createLottoTickets(amount)
        tickets.forEach { ticket ->
            val numbers = ticket.getNumbers()
            assertEquals(6, numbers.size)
            assertEquals(numbers, numbers.sorted())
        }
    }

    @Test
    fun `determineRankCounts should correctly count ranks`() {
        val lottoService = LottoService()

        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7

        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 5, 10)),
            Lotto(listOf(1, 2, 3, 4, 10, 11)),
            Lotto(listOf(1, 2, 3, 10, 11, 12)),
            Lotto(listOf(1, 2, 10, 11, 12, 13))
        )

        val rankCounts = lottoService.determineRankCounts(tickets, winningLotto, bonusNumber)

        assertEquals(1, rankCounts[Rank.FIRST])
        assertEquals(1, rankCounts[Rank.SECOND])
        assertEquals(1, rankCounts[Rank.THIRD])
        assertEquals(1, rankCounts[Rank.FOURTH])
        assertEquals(1, rankCounts[Rank.FIFTH])
        assertEquals(1, rankCounts.getOrDefault(Rank.NONE, 0))
    }
} 