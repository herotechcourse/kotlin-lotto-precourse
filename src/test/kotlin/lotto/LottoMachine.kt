package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class LottoMachineTest {

    @Test
    fun `should create lotto tickets correctly`() {
        val machine = LottoMachine()
        val tickets = machine.createTickets(8000) // 8000원으로 8개의 티켓 생성

        assertEquals(8, tickets.size)
    }
}
