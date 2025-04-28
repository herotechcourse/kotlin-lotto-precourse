package lotto.service

import lotto.domain.Lotto
import lotto.domain.WinningNumbers
import lotto.domain.Rank
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoServiceStatisticsTest {
    @Test
    fun `statistics count ranks correctly`() {
        val tickets = listOf(
            Lotto(listOf(1,2,3,4,5,6)),
            Lotto(listOf(1,2,3,4,5,7)),
            Lotto(listOf(1,2,3,4,5,8)),
            Lotto(listOf(1,2,3,4,9,10)),
            Lotto(listOf(1,2,3,11,12,13))
        )
        val winning = WinningNumbers(listOf(1,2,3,4,5,6), 7)
        val stats = LottoService.calculateStatistics(tickets, winning)

        assertThat(stats.rankCounts).containsExactlyInAnyOrderEntriesOf(
            mapOf(
                Rank.FIRST to 1,
                Rank.SECOND to 1,
                Rank.THIRD to 1,
                Rank.FOURTH to 1,
                Rank.FIFTH to 1
            )
        )
        assertThat(stats.totalPrize).isEqualTo(
            Rank.FIRST.prize +
                    Rank.SECOND.prize +
                    Rank.THIRD.prize +
                    Rank.FOURTH.prize +
                    Rank.FIFTH.prize
        )
    }
}
