package lotto.model

import lotto.Lotto
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoTicketMachineTest {

    private lateinit var lottoTicketMachine: LottoTicketMachine

    @BeforeEach
    fun setUp() {
        lottoTicketMachine = SequentialLottoTicketMachine()
    }

    @Test
    fun `lotto ticket machine create lotto tickets`() {
        val lottoTicketMachine: LottoTicketMachine = SequentialLottoTicketMachine()
        val lottoTicket = lottoTicketMachine.buyLotto(6)
        assertEquals(lottoTicket.size, 6)
        assertEquals(lottoTicket[0].getNumbers(), listOf(1, 2, 3, 4, 5, 6))
        assertEquals(lottoTicket[1].getNumbers(), listOf(11, 12, 13, 14, 15, 16))
        assertEquals(lottoTicket[2].getNumbers(), listOf(21, 22, 23, 24, 25, 26))
        assertEquals(lottoTicket[3].getNumbers(), listOf(31, 32, 33, 34, 35, 36))
        assertEquals(lottoTicket[4].getNumbers(), listOf(41, 42, 43, 44, 45, 1))
        assertEquals(lottoTicket[5].getNumbers(), listOf(1, 2, 3, 4, 5, 6))
    }
}
