package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    fun `creates the correct number of lotto tickets`() {
        val lottoMachine = LottoMachine()
        val tickets = lottoMachine.createTickets(5)

        assertThat(tickets).hasSize(5)
    }

    @Test
    fun `each ticket must have exactly six numbers`() {
        val lottoMachine = LottoMachine()
        val tickets = lottoMachine.createTickets(3)

        tickets.forEach { ticket ->
            assertThat(ticket.getNumbers()).hasSize(6)
        }
    }
}