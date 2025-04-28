package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketTest {

    @Test
    fun `constructor sorts and enforces uniqueness`() {
        val ticket = LottoTicket(listOf(5, 3, 42, 1, 17, 30))
        assertThat(ticket.numbers).containsExactly(1, 3, 5, 17, 30, 42)
    }

    @Test
    fun `createRandom returns 6 unique numbers in range`() {
        val ticket = LottoTicket.createRandom()
        assertThat(ticket.numbers).hasSize(6)
        assertThat(ticket.numbers.distinct()).hasSize(6)
        assertThat(ticket.numbers).allMatch { it in 1..45 }
    }
}
