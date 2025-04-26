package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue

class LottoGenereatorTest {
    @Test
    fun `lotto generator creates ticket with 6 unique numbers between 1 and 45`() {
        val lottoGenerator = LottoGenerator()
        val ticket = lottoGenerator.getRandomNumbers()
        val numbers = ticket.getNumbers()
        assertEquals(6, numbers.size)
        assertTrue(numbers.all { it >= 1 && it <= 45 })
    }
    @Test
    fun `creates correct number of tickets`() {
        val lottoGenerator = LottoGenerator()
        val numberOfTickets = 4
        val tickets = lottoGenerator.getTickets(numberOfTickets)
        assertEquals(numberOfTickets, tickets.size)
    }
}