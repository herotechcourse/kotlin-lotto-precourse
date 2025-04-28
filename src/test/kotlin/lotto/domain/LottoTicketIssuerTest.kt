package lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoTicketIssuerTest {
    @Test
    fun `should issue the correct number of lotto tickets based on purchase amount`() {
        val purchaseAmount = 5000
        val expectedTicketCount = purchaseAmount / LottoConstants.Ticket.PRICE

        val issuer = LottoTicketIssuer()
        val issuedTickets = issuer.issueLottoTickets(purchaseAmount)

        assertEquals(expectedTicketCount, issuedTickets.size)
    }

    @Test
    fun `should issue tickets with six unique numbers between 1~45 each`() {
        val purchaseAmount = 10000
        val issuer = LottoTicketIssuer()
        val issuedTickets = issuer.issueLottoTickets(purchaseAmount)

        for (ticket in issuedTickets) {
            val ticketNumbers = ticket.getNumbers

            assertEquals(6, ticketNumbers.size)
            assertEquals(ticketNumbers.toSet().size, ticketNumbers.size)
            assert(
                    ticketNumbers.all {
                        it in LottoConstants.NumberRange.MIN..LottoConstants.NumberRange.MAX
                    }
            )
        }
    }
}
