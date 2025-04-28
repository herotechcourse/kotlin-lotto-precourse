package lotto

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LotteryGameTest {
    private val game = LotteryGame()

    @Test
    fun `calculate ticket count based on purchase amount`() {
        val purchaseAmount = 5000
        assertEquals(5, game.getTicketCount(purchaseAmount))
    }

    @Test
    fun `verify ticket generation count`() {
        val purchaseAmount = 3000
        val tickets = game.generateAllTickets(purchaseAmount)
        assertEquals(3, tickets.size)
    }

    @Test
    fun `validate generated ticket properties`() {
        val purchaseAmount = 1000
        val tickets = game.generateAllTickets(purchaseAmount)
        val ticket = tickets.first()

        assertEquals(6, ticket.getTicketNumbers().size)
        assertTrue(ticket.getTicketNumbers().all { it in 1..45 })
        assertEquals(ticket.getTicketNumbers().size, ticket.getTicketNumbers().toSet().size)
    }

    @Test
    fun `calculate winning results`() {
        val tickets = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(7, 8, 9, 10, 11, 12))
        )
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7
        val purchaseAmount = 2000

        val results = game.getLotteryResults(tickets, winningNumbers, bonusNumber, purchaseAmount)

        assertEquals(5, results.winningStatuses.size)
        assertTrue(results.returnRate.isNotEmpty())
    }
}