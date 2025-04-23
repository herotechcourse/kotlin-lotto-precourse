package lotto.business

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue

import lotto.Lotto
import org.junit.jupiter.api.Test

class LottoServiceTest {

    private val lottoService = LottoService()

    @Test
    fun `generateSingleLottoTicket generates a valid lotto ticket with 6 unique numbers`() {
        val ticket = lottoService.generateSingleLottoTicket()

        val numbers = ticket.getNumbers()
        assertEquals(6, numbers.size)
        assertTrue(numbers.all { it in 1..45 })
        assertTrue(numbers.toSet().size == numbers.size)
    }

    @Test
    fun `generateLottoTickets generates the correct number of tickets`() {
        val numberOfTickets = 5L
        val tickets = lottoService.generateLottoTickets(numberOfTickets)

        assertEquals(numberOfTickets, tickets.size.toLong())
        tickets.forEach { ticket ->
            val numbers = ticket.getNumbers()
            assertEquals(6, numbers.size)
            assertTrue(numbers.all { it in 1..45 })
            assertTrue(numbers.toSet().size == numbers.size)
        }
    }

    @Test
    fun `getWinningStatistics correctly counts lotto match types`() {
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = 7
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 8, 9)),
            Lotto(listOf(1, 2, 3, 8, 9, 10)),
            Lotto(listOf(11, 12, 13, 14, 15, 16))
        )

        val statistics = lottoService.getWinningStatistics(tickets, winningLotto, bonusNumber)

        assertEquals(1, statistics[LottoMatchType.SIX_MATCHES])
        assertEquals(1, statistics[LottoMatchType.FIVE_MATCHES_BONUS])
        assertEquals(1, statistics[LottoMatchType.FOUR_MATCHES])
        assertEquals(1, statistics[LottoMatchType.THREE_MATCHES])
        assertEquals(0, statistics[LottoMatchType.FIVE_MATCHES])
    }

    @Test
    fun `getLottoMatchType returns correct match type`() {
        // Case 1: 6 matches
        val ticket1 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val matchType1 = lottoService.getLottoMatchType(6, ticket1.getNumbers(), 7)
        assertEquals(LottoMatchType.SIX_MATCHES, matchType1)

        // Case 2: 5 matches with bonus
        val ticket2 = Lotto(listOf(1, 2, 3, 4, 5, 7))
        val matchType2 = lottoService.getLottoMatchType(5, ticket2.getNumbers(), 7)
        assertEquals(LottoMatchType.FIVE_MATCHES_BONUS, matchType2)

        // Case 3: 5 matches without bonus
        val ticket3 = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val matchType3 = lottoService.getLottoMatchType(5, ticket3.getNumbers(), 7)
        assertEquals(LottoMatchType.FIVE_MATCHES, matchType3)

        // Case 4: 4 matches
        val ticket4 = Lotto(listOf(1, 2, 3, 4, 8, 9))
        val matchType4 = lottoService.getLottoMatchType(4, ticket4.getNumbers(), 7)
        assertEquals(LottoMatchType.FOUR_MATCHES, matchType4)

        // Case 5: 3 matches
        val ticket5 = Lotto(listOf(1, 2, 3, 8, 9, 10))
        val matchType5 = lottoService.getLottoMatchType(3, ticket5.getNumbers(), 7)
        assertEquals(LottoMatchType.THREE_MATCHES, matchType5)

        // Case 6: No match
        val ticket6 = Lotto(listOf(11, 12, 13, 14, 15, 16))
        val matchType6 = lottoService.getLottoMatchType(0, ticket6.getNumbers(), 7)
        assertEquals(null, matchType6)
    }
}
