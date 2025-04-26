package lotto.model

import lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketsTest {

    @Test
    fun `should create correct number of Lotto tickets`() {
        val ticketCount = 5
        val lottoTickets = LottoTickets(ticketCount)

        assertThat(lottoTickets.getTickets()).hasSize(ticketCount)
        assertThat(lottoTickets.getTickets()).allSatisfy { ticket ->
            assertThat(ticket).isInstanceOf(Lotto::class.java)
        }
    }
}
