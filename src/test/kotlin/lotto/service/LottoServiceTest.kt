package lotto.service

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.Assertions.assertThat

class LottoServiceTest {

    @Test
    fun `generates correct number of tickets based on amount`() {
        val tickets = LottoService.generateTickets(3000)
        assertThat(tickets).hasSize(3)
    }

    @Test
    fun `each ticket contains 6 unique numbers`() {
        val tickets = LottoService.generateTickets(1000)
        val numbers = tickets.first().numbers

        assertThat(numbers).hasSize(6)
        assertThat(numbers.toSet()).hasSize(6)
        assertThat(numbers.all { it in 1..45 }).isTrue()
    }

    @Test
    fun `throws exception if amount is not multiple of 1000`() {
        assertThatThrownBy {
            LottoService.generateTickets(2500)
        }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("[ERROR] Amount must be a multiple of 1,000.")
    }
}