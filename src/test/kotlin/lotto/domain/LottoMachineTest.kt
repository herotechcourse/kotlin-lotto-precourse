package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class LottoMachineTest {

    @Test
    fun `구입 금액에 맞게 티켓 수 발행`() {
        val machine = LottoMachine()
        val tickets = machine.buyLottoTickets(5000)

        assertThat(tickets).hasSize(5)
    }
}
