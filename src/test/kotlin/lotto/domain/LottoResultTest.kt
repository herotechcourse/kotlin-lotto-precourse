package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class LottoResultTest {
    @Test
    fun `calculate prize from matches`() {
        assertEquals(Prize.FIRST, Prize.from(6, false))
        assertEquals(Prize.SECOND, Prize.from(5, true))
        assertEquals(Prize.THIRD, Prize.from(5, false))
        assertEquals(Prize.FOURTH, Prize.from(4, false))
        assertEquals(Prize.FIFTH, Prize.from(3, false))
        assertEquals(Prize.NONE, Prize.from(2, false))
    }

    @Test
    fun `calculate total prize`() {
        val tickets = listOf(
            LottoTicket.from(listOf(1, 2, 3, 4, 5, 6)),
            LottoTicket.from(listOf(1, 2, 3, 4, 5, 7))
        )
        val winningNumbers = WinningNumbers.from(listOf(1, 2, 3, 4, 5, 6), 7)
        val result = LottoResult.from(tickets, winningNumbers)
        
        assertEquals(2_000_000_000 + 30_000_000, result.calculateTotalPrize())
    }

    @Test
    fun `calculate return rate`() {
        val tickets = listOf(
            LottoTicket.from(listOf(1, 2, 3, 4, 5, 6)),
            LottoTicket.from(listOf(1, 2, 3, 4, 5, 7))
        )
        val winningNumbers = WinningNumbers.from(listOf(1, 2, 3, 4, 5, 6), 7)
        val result = LottoResult.from(tickets, winningNumbers)
        
        assertEquals("101500000", result.calculateReturnRate(2000))
    }

    @Test
    fun `calculate return rate with whole number`() {
        val tickets = listOf(
            LottoTicket.from(listOf(1, 2, 3, 4, 5, 6))
        )
        val winningNumbers = WinningNumbers.from(listOf(1, 2, 3, 4, 5, 6), 7)
        val result = LottoResult.from(tickets, winningNumbers)
        
        assertEquals("200000000", result.calculateReturnRate(1000))
    }
} 