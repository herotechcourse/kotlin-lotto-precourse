package lotto

import lotto.domain.LottoTicket
import lotto.domain.Rank
import lotto.service.LottoService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class LottoServiceTest {

    private val lottoService = LottoService()

    @Test
    fun `generateTickets should generate the correct number of tickets`() {
        val purchaseAmount = 5000
        val tickets = lottoService.generateTickets(purchaseAmount)
        assertEquals(5, tickets.size, "Should generate 5 tickets for 5000 amount")
    }

    @Test
    fun `evaluateResults should correctly evaluate tickets`() {
        val tickets = listOf(
            LottoTicket(lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))),
            LottoTicket(lotto = Lotto(listOf(7, 8, 9, 10, 11, 12))),
            LottoTicket(lotto = Lotto(listOf(1, 2, 3, 4, 5, 7)))
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val results = lottoService.evaluateResults(tickets, winningNumbers, bonusNumber)

        assertEquals(1, results[Rank.FIRST], "There should be 1 ticket with 6 matches.")
        assertEquals(1, results[Rank.SECOND], "There should be 1 ticket with 5 matches + bonus.")
        assertEquals(0, results[Rank.THIRD], "There should be 0 tickets with 5 matches without bonus.")
        assertEquals(0, results[Rank.FOURTH], "There should be 0 tickets with 4 matches.")
        assertEquals(0, results[Rank.FIFTH], "There should be 0 tickets with 3 matches.")
    }


    @Test
    fun `calculateProfitRate should return the correct profit rate`() {
        val tickets = listOf(
            LottoTicket(lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))),
            LottoTicket(lotto = Lotto(listOf(1, 2, 3, 4, 5, 7)))
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val purchaseAmount = 2000
        val results = lottoService.evaluateResults(tickets, winningNumbers, bonusNumber)

        val profitRate = lottoService.calculateProfitRate(purchaseAmount, results)

        assertEquals(1.015E8, profitRate, 0.1, "Profit rate should be calculated correctly")
    }
}
