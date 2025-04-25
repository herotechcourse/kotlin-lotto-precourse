package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

class LottoMachineTest {
    @Test
    fun `throws if number of tickets less than 0`() {
        assertThrows<IllegalArgumentException> {
            LottoMachine.generateTickets(0)
            LottoMachine.generateTickets(-1)
        }
    }

    @Test
    fun `returns the correct amount of tickets`() {
        val amount = 8000
        val ticketCount = LottoMachine.getTicketCount(amount)
        assertThat(ticketCount).isEqualTo(8)
    }
}