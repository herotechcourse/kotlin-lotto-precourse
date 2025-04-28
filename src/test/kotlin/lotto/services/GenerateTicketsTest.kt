package lotto.services

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GenerateTicketsTest {

    private val generateTickets = GenerateTickets()

    @Test
    fun `Enter a budget and return the number of lotto tickets available for purchase`() {
        val budget = 8000
        val count = generateTickets.getLotteryCount(budget)

        assertThat(count).isEqualTo(8)
    }

    @Test
    fun `count generates a list of lotto numbers with count number of duplicates`() {
        val count = 5
        val tickets = generateTickets.run(count)

        assertThat(tickets).hasSize(count)
        tickets.forEach { ticket ->
            assertThat(ticket).hasSize(6)
            assertThat(ticket).allMatch { it in 1..45 }
            assertThat(ticket).doesNotHaveDuplicates()
        }
    }

    @Test
    fun `getRandom returns 6 numbers from 1 to 45 without duplicates`() {
        val randomTicket = generateTickets.getRandom()

        assertThat(randomTicket).hasSize(6)
        assertThat(randomTicket).allMatch { it in 1..45 }
        assertThat(randomTicket).doesNotHaveDuplicates()
    }
}
