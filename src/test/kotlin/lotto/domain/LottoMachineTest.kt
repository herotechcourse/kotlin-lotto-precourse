package lotto.domain


import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {

    @Test
    fun `generates correct number of tickets based on purchase amount`() {
        // given
        val purchaseAmount = 7000
        val lottoMachine = LottoMachine()

        // when
        val tickets = lottoMachine.generateLottoTickets(purchaseAmount)

        // then
        assertThat(tickets).hasSize(7)
    }

    @Test
    fun `each ticket contain 6 unique numbers between 1 and 45`() {
        // given
        val lottoMaachine = LottoMachine()

        // when
        val tickets = lottoMaachine.generateLottoTickets(1000)

        // then
        val numbers = tickets[0].getNumbers() // 1,000 won represents 1 ticket, so only check tickets[0]
        assertThat(numbers).hasSize(6)
        assertThat(numbers.toSet().size).isEqualTo(6)
        assertThat(numbers).allMatch { it in 1..45}
    }
}