package lotto

import lotto.domain.LottoMachine
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun shouldIssueCorrectNumberOfTickets() {
        val machine = LottoMachine()
        val tickets = machine.issueLotto(5)
        assertThat(tickets).hasSize(5)
    }

    @Test
    fun shouldGenerateNumbersBetweenOneAndFortyFive() {
        val machine = LottoMachine()
        val tickets = machine.issueLotto(10)
        tickets.forEach { ticket ->
            assertThat(ticket.getNumbers()).allMatch { it in 1..45 }
        }
    }
}
