package lotto.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RandomLottoTicketMachineTest {

    @Test
    fun `lotto ticket machine create lotto tickets`() {
        val lottoTicketMachine: LottoTicketMachine = RandomLottoTicketMachine()
        val lottoTicket = lottoTicketMachine.buyLotto(3)
        assertEquals(lottoTicket.size, 3)
    }

}