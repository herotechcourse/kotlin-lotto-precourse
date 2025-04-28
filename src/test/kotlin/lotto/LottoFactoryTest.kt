package lotto

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

class LottoFactoryTest {
    @Test
    fun `createMultipleTickets returns the correct ticket count`() {
        val amount = 5_000   // ==> should create 5 tickets
        val tickets = LottoFactory.createMultipleTickets(amount)

        assertEquals(5, tickets.size)
    }

    @Test
    fun `amount smaller than 1_000 yields zero tickets`() {
        val tickets = LottoFactory.createMultipleTickets(500)

        assertTrue(tickets.isEmpty())
    }
}