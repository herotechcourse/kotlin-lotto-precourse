package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottosTest {
    @Test
    fun `Throws when the number of lotto doesn't equeal to ticketCounts`() {
        val ticketCount = 5
        val lottos = Lottos(mutableListOf(), ticketCount)

        assertEquals(ticketCount, lottos.getTickets().size)
    }
}