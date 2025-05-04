package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoMachineTest {
 
     @Test
    fun `calcTicketNumber should return correct number of tickets`() {
        val lottoMachine = LottoMachine()
        val purchaseAmount = 5000

        val numberOfTickets = lottoMachine.calcTicketNumber(purchaseAmount)

        assertEquals(5, numberOfTickets)
    }

    @Test
    fun `issueTickets should issue correct number of unique tickets`() {
        val ticketsCount = 3
        val lottoMachine=LottoMachine()
        val tickets = lottoMachine.issueTickets(ticketsCount)

        assertEquals(ticketsCount, tickets.size)
        tickets.forEach { ticket ->
            assertEquals(6, ticket.getNumbers().size)
            assertEquals(6, ticket.getNumbers().toSet().size) 
        }
    }

    @Test
    fun `checkMatches should correctly update match map`() {
        val lottoMachine=LottoMachine()

        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val winningTicket = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val noMatchTicket = Lotto(listOf(11, 12, 13, 14, 15, 16))

        val tickets = mutableListOf(winningTicket, noMatchTicket)
        
        lottoMachine.checkMatches(tickets, winningNumbers, bonusNumber)

        assertEquals(1, lottoMachine.matchMap[MatchCondition.MATCH_6]?.count)
        assertEquals(0, lottoMachine.matchMap[MatchCondition.MATCH_3]?.count)
    }

    @Test
    fun `calcReturnRate should return correct return percentage`() {
        val lottoMachine=LottoMachine()

        val purchaseAmount = 10000

        lottoMachine.matchMap[MatchCondition.MATCH_4]?.count = 1 // 50,000
        lottoMachine.matchMap[MatchCondition.MATCH_5]?.count = 1 // 1,500,000

        val returnRate = lottoMachine.calcReturnRate(purchaseAmount)

        // (50,000 + 1,500,000) / 10,000 * 100 = 15,500%
        assertEquals(15500.0, returnRate)
    }
}