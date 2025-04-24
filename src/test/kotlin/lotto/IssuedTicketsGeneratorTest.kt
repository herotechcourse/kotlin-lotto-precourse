package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IssuedTicketsGeneratorTest {

    @Test
    fun `create issued tickets by purchased ticket count`() {
        val purchaseAmount = 8000
        val issuedTicket = IssuedTicket(purchaseAmount, DefaultRandomGenerator())

        val issuedTickets = IssuedTicketsGenerator.of(issuedTicket)

        assertEquals(8, issuedTickets.size)
    }
}
