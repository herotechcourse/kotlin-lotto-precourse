package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {

    private val lottoMachine = LottoMachine()

    @Test
    fun `generates correct number of lotto tickets`() {
        val purchaseAmount = 5000 // 5 tickets
        val tickets = lottoMachine.generateTickets(purchaseAmount)

        assertThat(tickets).hasSize(5)
    }
}