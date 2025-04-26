package lotto

import lotto.generator.RandomNumbersGenerator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoTicketMachineTest {

    @Test
    fun `purchase creates expected number of tickets`() {
        val ticketMachine = LottoTicketMachine()
        val count = 3

        val lottos = ticketMachine.purchase(count, RandomNumbersGenerator())

        assertEquals(lottos.size, count)
    }

}