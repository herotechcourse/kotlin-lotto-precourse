package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class LottoResultTest {
    @Test
    fun `should calculate rank counts and return rate correctly`() {
        val winningLotto = WinningLotto(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            bonusNumber = 7
        )
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 5, 8)),
            Lotto(listOf(1, 2, 3, 4, 10, 11)),
            Lotto(listOf(1, 2, 3, 10, 11, 12)),
            Lotto(listOf(10, 11, 12, 13, 14, 15))
        )

        val result = LottoResult(lottos, winningLotto)

        assertThat(result.rankCount[LottoRank.FIRST]).isEqualTo(1)
        assertThat(result.rankCount[LottoRank.SECOND]).isEqualTo(1)
        assertThat(result.rankCount[LottoRank.THIRD]).isEqualTo(1)
        assertThat(result.rankCount[LottoRank.FOURTH]).isEqualTo(1)
        assertThat(result.rankCount[LottoRank.FIFTH]).isEqualTo(1)
        assertThat(result.rankCount[LottoRank.NONE]).isEqualTo(1)

        val totalPrize = 2_000_000_000L + 30_000_000L + 1_500_000L + 50_000L + 5_000L
        val totalSpent = 6_000L
        val expectedRate = totalPrize * 100.0 / totalSpent

        assertThat(result.rate).isEqualTo(expectedRate)
    }
}
