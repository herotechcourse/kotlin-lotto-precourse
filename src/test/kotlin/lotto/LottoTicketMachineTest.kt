package lotto

import lotto.generator.FixedNumbersGenerator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoTicketMachineTest {

    @Test
    fun `purchase creates expected number of tickets`() {
        val ticketMachine = LottoTicketMachine()
        val count = 3;
        val lottoNumber = listOf(1, 2, 3, 4, 5, 6)

        val lottos = ticketMachine.purchase(count, FixedNumbersGenerator(lottoNumber))

        assertEquals(lottos.size, count)
    }

}