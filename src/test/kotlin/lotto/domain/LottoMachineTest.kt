package lotto.domain

import lotto.Lotto
import lotto.support.TICKET_PRICE
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    fun `generates correct number of tickets`() {
        val purchaseAmount = 5000

        val tickets = LottoMachine.generateTickets(purchaseAmount)

        assertThat(tickets).hasSize(purchaseAmount / TICKET_PRICE)
    }

    @Test
    fun `each ticket has six unique numbers`() {
        val purchaseAmount = 1000

        val tickets = LottoMachine.generateTickets(purchaseAmount)

        val numbers = tickets.first().getNumbers()

        assertThat(numbers).hasSize(6)
        assertThat(numbers.toSet().size).isEqualTo(6)
    }
}
