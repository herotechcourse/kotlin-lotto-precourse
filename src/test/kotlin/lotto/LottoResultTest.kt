package lotto


import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {
    private val prizeTable = listOf(
        Prize(3, false, 5000, "3 Matches"),
        Prize(4, false, 50000, "4 Matches"),
        Prize(5, false, 1500000, "5 Matches"),
        Prize(5, true, 30000000, "5 Matches + Bonus Ball"),
        Prize(6, false, 2000000000, "6 Matches")
    )

    @Test
    fun `calculates total prize money`() {
        val matchCounts = listOf(1, 1, 1, 1, 1)
        val purchaseAmount = 5000
        val lottoResult = LottoResult(matchCounts, prizeTable, purchaseAmount)
        val totalPrize = lottoResult.totalPrizeMoney()
        val expected = (1 * 5000) + (1 * 50000) + (1 * 1500000) + (1 * 30000000) + (1 * 2000000000)

        assertThat(totalPrize).isEqualTo(expected)
    }

    @Test
    fun `calculates return rate`() {
        val matchCounts = listOf(0, 0, 1, 1, 0) // 5개+보너스 1번 (30,000,000원)
        val purchaseAmount = 5000
        val lottoResult = LottoResult(matchCounts, prizeTable, purchaseAmount)
        val totalPrize = lottoResult.totalPrizeMoney()
        val returnRate = totalPrize.toDouble() / purchaseAmount * 100
        val expectedRate = 31500000.0 / 5000 * 100

        assertThat(returnRate).isEqualTo(expectedRate)
    }
}