// src/test/kotlin/lotto/LottoStatisticsTest.kt
package lotto

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoStatisticsTest {
    private val purchaseAmount = 14000
    private val baseResults = listOf(
        LottoRank.FIFTH,  // 5,000원
        LottoRank.FOURTH, // 50,000원
        LottoRank.THIRD,  // 1,500,000원
        LottoRank.SECOND, // 30,000,000원
        LottoRank.FIRST   // 2,000,000,000원
    )

    @Test
    @DisplayName("countByRank이 등수별 개수를 정확히 집계해야 한다")
    fun testCountByRank() {
        val stats = LottoStatistics(baseResults, purchaseAmount)
        val counts = stats.countByRank()
        assertThat(counts).containsEntry(LottoRank.FIFTH, 1)
        assertThat(counts).containsEntry(LottoRank.FOURTH, 1)
        assertThat(counts).containsEntry(LottoRank.THIRD, 1)
        assertThat(counts).containsEntry(LottoRank.SECOND, 1)
        assertThat(counts).containsEntry(LottoRank.FIRST, 1)
    }

    @Test
    @DisplayName("totalPrize가 모든 당첨금을 합산해야 한다")
    fun testTotalPrize() {
        val stats = LottoStatistics(baseResults, purchaseAmount)
        val expected = 5_000L + 50_000L + 1_500_000L + 30_000_000L + 2_000_000_000L
        assertThat(stats.totalPrize()).isEqualTo(expected)
    }

    @Test
    @DisplayName("returnRate가 수익률을 소수점 첫째 자리까지 반올림해야 한다")
    fun testReturnRate() {
        val stats1 = LottoStatistics(listOf(LottoRank.FIFTH), 10000)
        assertThat(stats1.returnRate()).isEqualTo(50.0)

        val stats2 = LottoStatistics(listOf(LottoRank.THIRD), 10000)
        assertThat(stats2.returnRate()).isEqualTo(15000.0)

        val stats3 = LottoStatistics(listOf(LottoRank.FIFTH), 14000)
        assertThat(stats3.returnRate()).isEqualTo(35.7)
    }
}
