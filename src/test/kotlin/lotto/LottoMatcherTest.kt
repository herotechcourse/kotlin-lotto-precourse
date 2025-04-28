package lotto

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

class LottoMatcherTest {
    private val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
    private val bonusNumber = 7
    private val matcher = LottoMatcher(winningNumbers, bonusNumber)

    private fun ticketOf(vararg n: Int) = Lotto(n.toList())

    private fun expectedTotal(vararg ranks: PrizeRank) =
        ranks.sumOf { it.prizeMoney }

    @Test
    fun `no-match tickets yield zero prize and 0 pct rate`() {
        val tickets = buildList {
            repeat(3) { add(ticketOf(11, 12, 13, 14, 15, 16)) }  // 0 or 1–2 matches only
        }

        val result = matcher.calculatePrizeResult(tickets)

        // every rank except NONE should have 0 count
        PrizeRank.entries.filter { it != PrizeRank.NONE }.forEach {
            assertEquals(0, result.count[it])
        }
        assertEquals(0f, result.returnRate)
    }

    @Test
    fun `all ranks are counted exactly once and rate is correct`() {
        val tickets = listOf(
            ticketOf(1, 2, 3, 4, 5, 6),          // 6 match  -> FIRST
            ticketOf(1, 2, 3, 4, 5, 7),          // 5+bonus  -> SECOND
            ticketOf(1, 2, 3, 4, 5, 45),         // 5        -> THIRD
            ticketOf(1, 2, 3, 4, 44, 45),        // 4        -> FOURTH
            ticketOf(1, 2, 3, 43, 44, 45),       // 3        -> FIFTH
            ticketOf(1, 2, 3, 43, 44, 45),       // 3        -> FIFTH
            ticketOf(1, 2, 42, 43, 44, 45)       // 2        -> NONE
        )

        val result = matcher.calculatePrizeResult(tickets)

        // ----- counts -----
        assertEquals(1, result.count[PrizeRank.FIRST])
        assertEquals(1, result.count[PrizeRank.SECOND])
        assertEquals(1, result.count[PrizeRank.THIRD])
        assertEquals(1, result.count[PrizeRank.FOURTH])
        assertEquals(2, result.count[PrizeRank.FIFTH])
        assertEquals(1, result.count[PrizeRank.NONE])

        // ----- rate of return -----
        val totalPurchase = tickets.size * 1_000  // 6 tickets × 1 000 KRW
        val expectedRate = expectedTotal(
            PrizeRank.FIRST,
            PrizeRank.SECOND,
            PrizeRank.THIRD,
            PrizeRank.FOURTH,
            PrizeRank.FIFTH,
            PrizeRank.FIFTH
        ) / totalPurchase.toFloat()

        assertEquals(expectedRate, result.returnRate)
    }
}