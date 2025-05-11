package lotto

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoGeneratorTest {
    @Test
    fun `issue 10 lotto tickets`() {
        val purchaseAmount = Money(PURCHASE_AMOUNT)
        val lottoTickets = LottoGenerator.issue(purchaseAmount)
        assertEquals(lottoTickets.size, purchaseAmount.value / TICKET_PRICE)
    }

    @Test
    fun `each lotto ticket contains 6 unique numbers`() {
        val purchaseAmount = Money(PURCHASE_AMOUNT)
        val lottoTickets = LottoGenerator.issue(purchaseAmount)
        assertTrue(lottoTickets.all { it.getNumbers().toSet().size == TICKET_SIZE })
    }

    companion object {
        private const val TICKET_PRICE = 1000
        private const val PURCHASE_AMOUNT = 10_000
        private const val TICKET_SIZE = 6
    }
}