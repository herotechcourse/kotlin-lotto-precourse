package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.withinPercentage
import org.junit.jupiter.api.Test

class LottoStatisticsTest {

    @Test
    fun `category counter true`() {
        val results = listOf(
            LottoResult.FIRST,
            LottoResult.FIFTH, LottoResult.FIFTH,
            LottoResult.FOURTH
        )
        val stats = LottoStatistics(results, purchaseAmount = 4000)
        assertThat(stats.count(LottoResult.FIRST)).isEqualTo(1)
        assertThat(stats.count(LottoResult.FIFTH)).isEqualTo(2)
        assertThat(stats.count(LottoResult.FOURTH)).isEqualTo(1)
    }

    @Test
    fun `profitRate calculates true`() {
        val stats = LottoStatistics(listOf(LottoResult.FIRST, LottoResult.FIFTH), purchaseAmount = 2000)
        assertThat(stats.profitRate).isCloseTo(1000002500.0, withinPercentage(0.0001))
    }
}
