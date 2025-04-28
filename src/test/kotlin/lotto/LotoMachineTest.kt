package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoMachineTest {
 
     @Test
    fun `calcTicketNumber should return correct number of tickets`() {
        val lottoMachine = LottoMachine()
        val purchaseAmount = 5000

        val numberOfTickets = lottoMachine.calcTicketNumber(purchaseAmount)

        assertEquals(5, numberOfTickets)
    }
}