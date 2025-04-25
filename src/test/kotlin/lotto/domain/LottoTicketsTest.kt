package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketsTest {

    @Test
    fun `creates correct number of tickets from amount`() {
        val tickets = LottoTickets.generate(5000)
        assertThat(tickets.size()).isEqualTo(5)
    }

    @Test
    fun `each ticket contains exactly six unique numbers in valid range`() {
        val tickets = LottoTickets.generate(1000)
        val lotto = tickets.getAll().first()

        val numbers = lotto.numbers()
        assertThat(numbers).hasSize(6)
        assertThat(numbers).doesNotHaveDuplicates()
        assertThat(numbers).allMatch { it in 1..45 }
    }

    @Test
    fun `getAll returns list of all generated tickets`() {
        val tickets = LottoTickets.generate(3000)
        assertThat(tickets.getAll()).hasSize(3)
    }
}