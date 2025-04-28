package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

class StatisticsTest {
    private lateinit var statistics: Statistics

    @BeforeEach
    fun setUp() {
        statistics = Statistics()
    }

    @Test
    fun `addResult should correctly count ranks`() {
        statistics.addResult(Rank.FIFTH)
        statistics.addResult(Rank.FIFTH)
        statistics.addResult(Rank.THIRD)

        assertEquals(2, statistics.getCount(Rank.FIFTH))
        assertEquals(1, statistics.getCount(Rank.THIRD))
        assertEquals(0, statistics.getCount(Rank.FIRST))
    }

    @Test
    fun `getCount should return zero for unregistered ranks`() {
        assertEquals(0, statistics.getCount(Rank.FIRST))
        assertEquals(0, statistics.getCount(Rank.SECOND))
        assertEquals(0, statistics.getCount(Rank.THIRD))
    }

    @Test
    fun `profitRate should be 0 when no tickets purchased`() {
        assertEquals("0.0", statistics.profitRate)
    }

    @Test
    fun `profitRate should calculate correctly for winning tickets`() {

        statistics.addResult(Rank.FIFTH)
        statistics.addResult(Rank.FOURTH)

        assertEquals("2750.0", statistics.profitRate)
    }

    @Test
    fun `profitRate should calculate correctly for jackpot`() {
        statistics.addResult(Rank.FIRST)

        assertEquals("200000000.0", statistics.profitRate)
    }

    @Test
    fun `profitRate should handle decimal rounding`() {
        statistics.addResult(Rank.SECOND)
        statistics.addResult(Rank.SECOND)
        statistics.addResult(Rank.SECOND)

        assertEquals("3000000.0", statistics.profitRate)
    }

    @Test
    fun `totalWinnings should accumulate correctly`() {
        statistics.addResult(Rank.FIFTH)   // 5,000
        statistics.addResult(Rank.FOURTH)  // 50,000
        statistics.addResult(Rank.THIRD)   // 1,500,000
        statistics.addResult(Rank.SECOND)  // 30,000,000
        statistics.addResult(Rank.FIRST)   // 2,000,000,000

        val expectedTotal = 5000L + 50000L + 1500000L + 30000000L + 2000000000L
        val totalSpent = 5 * 1000 // 5 tickets
        val expectedRate = (expectedTotal.toDouble() / totalSpent) * 100

        assertEquals("%.1f".format(expectedRate), statistics.profitRate)
    }

    @Test
    fun `profitRate should handle no winning tickets`() {

        statistics.addResult(Rank.FIFTH)
        statistics.addResult(Rank.FIFTH)


        assertEquals("0.0", Statistics().profitRate)
    }
}