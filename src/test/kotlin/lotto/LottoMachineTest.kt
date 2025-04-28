package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    fun `lotto machine generates correct number of tickets`() {
        val lottoMachine = LottoMachine()
        val tickets = lottoMachine.buyTickets(3)
        assertThat(tickets).hasSize(3)
    }

    @Test
    fun `each lotto ticket contains six unique numbers`() {
        val lottoMachine = LottoMachine()
        val tickets = lottoMachine.buyTickets(1)

        val numbers = tickets.first().numbers
        assertThat(numbers).hasSize(6)
        assertThat(numbers.toSet().size).isEqualTo(6)
    }
}
