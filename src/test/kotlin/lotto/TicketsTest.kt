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

    @Test
    fun `creates tickets with valid lotto numbers`() {
        val money = 1000

        val tickets = Tickets(money)

        assertThat(tickets.lottos).hasSize(1)
        val lotto = tickets.lottos[0]
        assertThat(lotto.numbers).hasSize(6)
        assertThat(lotto.numbers.distinct()).hasSize(6) // Ensure numbers are unique
        assertThat(lotto.numbers.all { it in 1..45 }).isTrue() // Ensure numbers are in range
    }

}
