package lotto

import lotto.domain.LottoMachine
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun `createTickets returns correct number of tickets`() {
        val tickets = LottoMachine.createTickets(5000)

        assertThat(tickets).hasSize(5)
    }
}
