package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.assertj.core.api.Assertions.assertThat

class TicketsTest {
    @Test
    fun `throws an exception when money is not a multiple of 1000`() {
        assertThrows<IllegalArgumentException> {
            Tickets(1500)
        }
    }

    @Test
    fun `throws an exception when money is negative`() {
        assertThrows<IllegalArgumentException> {
            Tickets(-1000)
        }
    }

    @Test
    fun `creates correct number of tickets based on money`() {
        val money = 8000

        val tickets = Tickets(money)

        assertThat(tickets.ticketCount).isEqualTo(8)
        assertThat(tickets.lottos).hasSize(8)
    }

}
