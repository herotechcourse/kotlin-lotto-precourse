package lotto

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottosResultTest {
    @Test
    fun `totalPrize sums prizes correctly`() {
        val winningNums = WinningNumbers(listOf("1", "2", "3", "4", "5", "6"), "7")
        val ticket3Match = Lotto(listOf(1, 2, 3, 10, 11, 12))   // 3 matches → 5_000 KRW
        val ticket5Bonus = Lotto(listOf(1, 2, 3, 4, 5, 7))      // 5 + bonus → 30_000_000 KRW
        val ticket6Match = Lotto(listOf(1, 2, 3, 4, 5, 6))      // 6 matches → 2_000_000_000 KRW

        val lottos = Lottos(mutableListOf(ticket3Match, ticket5Bonus, ticket6Match), 0)
        val result = LottosResult(lottos, winningNums)

        val total = result.totalPrize()

        val expected = 5000 + 30000000 + 2000000000
        assertEquals(expected, total)
    }

    @Test
    fun `calculateProfit returns correct formatted profit rate`() {
        // Given: single 3-match ticket (prize 5_000 KRW), cost = 1 * 1_000 KRW
        val winningNums = WinningNumbers(listOf("1", "2", "3", "4", "5", "6"), "7")
        val ticket = Lotto(listOf(1, 2, 3, 10, 11, 12))
        val lottos = Lottos(mutableListOf(ticket), 0)
        val result = LottosResult(lottos, winningNums)

        val profitText = result.calculateProfitRate()

        assertEquals("500.0%", profitText)
    }

}