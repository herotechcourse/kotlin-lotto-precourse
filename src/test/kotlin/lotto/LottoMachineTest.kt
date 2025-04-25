package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class LottoMachineTest {
    @Test
    fun `returns the correct count of tickets`() {
        val amount = 8000
        val ticketCount = LottoMachine.getTicketCount(amount)
        assertThat(ticketCount).isEqualTo(8)
    }
}