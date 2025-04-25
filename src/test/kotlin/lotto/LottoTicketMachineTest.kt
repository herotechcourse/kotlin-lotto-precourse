package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoTicketMachineTest {

    @Test
    fun `lotto ticket machine create lotto tickets`() {
        val lottoTicketMachine = LottoTicketMachine()
        val lottoTicket = lottoTicketMachine.buyLotto(
            PurchaseAmountDto(3),
            listOf(
                LottoTicketDto(listOf(1, 2, 3, 4, 5, 6)),
                LottoTicketDto(listOf(11, 12, 13, 14, 15, 16)),
                LottoTicketDto(listOf(31, 32, 33, 34, 35, 36))
            )
        )
        assertEquals(lottoTicket.size, 3)
        assertEquals(lottoTicket[0].getNumbers(), listOf(1, 2, 3, 4, 5, 6))
        assertEquals(lottoTicket[1].getNumbers(), listOf(11, 12, 13, 14, 15, 16))
        assertEquals(lottoTicket[2].getNumbers(), listOf(31, 32, 33, 34, 35, 36))

    }

}