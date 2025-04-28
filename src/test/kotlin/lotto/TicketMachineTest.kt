package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class TicketMachineTest {
    @Test
    @DisplayName("generateTickets generates the correct number of tickets with unique and valid numbers")
    fun generateCorrectNumberOfTickets() {
        val machine = TicketMachine()
        val tickets = machine.generateTickets(Config.TICKET_PRICE * 3)
        assertThat(tickets).hasSize(3)
        tickets.forEach { ticket ->
            val nums = ticket.getNumbers()
            assertThat(nums).hasSize(Config.LOTTO_NUMBER_COUNT)
            assertThat(nums.toSet()).hasSize(Config.LOTTO_NUMBER_COUNT)
            assertThat(nums.minOrNull()).isGreaterThanOrEqualTo(Config.MIN_LOTTO_NUMBER)
            assertThat(nums.maxOrNull()).isLessThanOrEqualTo(Config.MAX_LOTTO_NUMBER)
        }
    }
}
