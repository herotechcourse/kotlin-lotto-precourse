package lotto

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LottoGeneratorTest {
    @Test
    fun `issue 10 lotto tickets`() {
        val lottoTickets = LottoGenerator.issue(10_000)
        assertTrue(lottoTickets.size == 10_000 / TICKET_PRICE)
    }

    @Test
    fun `each lotto ticket contains 6 unique numbers`() {
        val lottoTickets = LottoGenerator.issue(10_000)
        assertTrue(lottoTickets.all { it.copyNumbers.toSet().size == TICKET_SIZE })
    }

    companion object {
        private const val TICKET_PRICE = 1000
        private const val TICKET_SIZE = 6
    }
}