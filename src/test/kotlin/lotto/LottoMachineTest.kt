package lotto

import lotto.domain.LottoMachine
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoMachineTest {
    @Test
    fun `throws an exception when purchase amount is less than lotto price`() {
        assertThrows<IllegalArgumentException> { LottoMachine.generateTickets(500) }
    }

    @Test
    fun `throws an exception when purchase amount is not divisible by lotto price`() {
        assertThrows<IllegalArgumentException> { LottoMachine.generateTickets(1500) }
    }

    @Test
    fun `generates the correct number of lotto tickets`() {
        val tickets = LottoMachine.generateTickets(3000)
        assertEquals(3, tickets.size)
    }
}
