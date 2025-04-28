package lotto.service

import lotto.domain.Lotto
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoServiceTest {
    @Test
    fun `generateTickets returns correct number of Lotto objects`() {
        val tickets = LottoService.generateTickets(5_000)
        assertThat(tickets).hasSize(5)
    }

    @Test
    fun `each Lotto has 6 unique sorted numbers in range 1 to 45`() {
        val tickets = LottoService.generateTickets(10_000)
        tickets.forEach { lotto ->
            val nums = lotto.numbers()
            assertThat(nums).hasSize(6)
            assertThat(nums.toSet()).hasSize(6)
            assertThat(nums).allMatch { it in 1..45 }
            assertThat(nums).isSorted()
        }
    }

    @Test
    fun `generateTickets with zero amount returns empty list`() {
        val tickets = LottoService.generateTickets(0)
        assertThat(tickets).isEmpty()
    }
}
