package lotto.domain

import lotto.Lotto
import lotto.constants.LottoRank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoRankerTest {
    @Test
    fun `counts lottos by their matching rank`() {
        val lottoRanker = LottoRanker()
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(1, 2, 3, 4, 5, 8)),
            Lotto(listOf(1, 2, 3, 4, 7, 8)),
            Lotto(listOf(10, 11, 12, 13, 14, 15))
        )
        val winningNumbers = setOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val result = lottoRanker.rankLotto(lottos, winningNumbers, bonusNumber)

        assertThat(result).containsExactlyInAnyOrderEntriesOf(
            mapOf(
                LottoRank.SIX_MATCH to 1,
                LottoRank.FIVE_MATCH_WITH_BONUS to 1,
                LottoRank.FIVE_MATCH to 1,
                LottoRank.FOUR_MATCH to 1,
                LottoRank.NONE to 1
            )
        )
    }

    @Test
    fun `calculates profit rate when there are various winning ranks`() {
        val lottoRanker = LottoRanker()
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(1, 2, 3, 4, 5, 7)),
            Lotto(listOf(10, 11, 12, 13, 14, 15))
        )
        val statistics = mapOf(
            LottoRank.SIX_MATCH to 1,
            LottoRank.FIVE_MATCH_WITH_BONUS to 1,
            LottoRank.NONE to 1
        )

        val result = lottoRanker.calculateProfit(lottos, statistics)

        assertThat(result).isEqualTo(67666666.7)
    }

    @Test
    fun `calculates profit rate when all lottos have no winning rank`() {
        val lottoRanker = LottoRanker()
        val lottos = listOf(
            Lotto(listOf(10, 11, 12, 13, 14, 15)),
            Lotto(listOf(16, 17, 18, 19, 20, 21)),
            Lotto(listOf(22, 23, 24, 25, 26, 27))
        )
        val statistics = mapOf(
            LottoRank.NONE to 3
        )

        val result = lottoRanker.calculateProfit(lottos, statistics)

        assertThat(result).isEqualTo(0.0)
    }

    @Test
    fun `calculates profit rate when all lottos win first prize`() {
        val lottoRanker = LottoRanker()
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(7, 8, 9, 10, 11, 12)),
            Lotto(listOf(13, 14, 15, 16, 17, 18))
        )
        val statistics = mapOf(
            LottoRank.SIX_MATCH to 3
        )

        val result = lottoRanker.calculateProfit(lottos, statistics)

        assertThat(result).isEqualTo(200000000.0)
    }
}