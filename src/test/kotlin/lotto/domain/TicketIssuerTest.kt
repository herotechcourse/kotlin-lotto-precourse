package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class TicketIssuerTest {

    @Test
    fun `issue ticket list`() {
        // given
        val issuer = TicketIssuer()
        val ticketCount = 5

        // when
        val tickets = issuer.issue(ticketCount)

        // then
        assert(tickets.size == ticketCount)
    }

    @Test
    fun `throws an exception when purchase number is 0 or less`() {
        // given
        val issuer = TicketIssuer()
        val invalidCount = -1

        // when & then
        assertThatThrownBy { issuer.issue(invalidCount) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Ticket count must be greater than 0.")
    }
}
