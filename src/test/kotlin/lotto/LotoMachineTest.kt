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
}