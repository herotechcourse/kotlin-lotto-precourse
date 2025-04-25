package lotto

import lotto.model.LottoTicketMachine
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoTicketMachineTest {

    @Test
    fun `lotto ticket machine create lotto tickets`() {
        val lottoTicketMachine = LottoTicketMachine()
        val lottoTicket = lottoTicketMachine.buyLotto(3)
        assertEquals(lottoTicket.size, 3)
    }

}