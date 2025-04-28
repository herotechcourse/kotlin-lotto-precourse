package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {

  @Test
  fun `issue correct number of tickets`() {
    val tickets = LottoMachine.issueTickets(5)
    assertThat(tickets).hasSize(5)
  }

  @Test
  fun `each ticket has 6 unique numbers`() {
    val ticket = LottoMachine.issueTickets(1)[0]
    val numbers = ticket.getNumbers()
    assertThat(numbers).hasSize(6)
    assertThat(numbers.distinct()).hasSize(6)
  }
}
