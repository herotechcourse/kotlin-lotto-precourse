package lotto.service

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TicketMachineTest {

    @Test
    fun `generates correct number of tickets with sorted numbers`() {
        val mockGenerator = { listOf(6, 1, 4, 3, 5, 2) }
        val machine = TicketMachine(mockGenerator)

        val tickets = machine.generateTickets(3000)

        assertThat(tickets).hasSize(3)
        tickets.forEach {
            assertThat(it).isInstanceOf(Lotto::class.java)
            assertThat(it.getNumbers()).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
        }
    }
}
