package lotto.view

import lotto.Lotto
import lotto.PrizeRank

object OutputView {

    private const val LOTTO_TICKETS_MESSAGE = "You have purchased %d tickets."
    private const val LOTTO_STATISTICS_MESSAGE =
        """
Winning Statistics
---
3 Matches (5,000 KRW) – %d tickets",
"4 Matches (50,000 KRW) – %d tickets",
"5 Matches (1,500,000 KRW) – %d tickets",
"5 Matches + Bonus Ball (30,000,000 KRW) – %d tickets",
"6 Matches (2,000,000,000 KRW) – %d tickets
"""

    fun showLottoTickets(lottoTickets: List<Lotto>) {
        println(LOTTO_TICKETS_MESSAGE.format(lottoTickets.size))
        lottoTickets.forEach { lotto ->
            println(lotto.numbers().map { it.value })
        }
    }

    fun showWinningStatistics(result: Map<PrizeRank, Int>) {
        println(
            LOTTO_STATISTICS_MESSAGE.format(
                result[PrizeRank.FIFTH],
                result[PrizeRank.FOURTH],
                result[PrizeRank.THIRD],
                result[PrizeRank.SECOND],
                result[PrizeRank.FIRST],
            )
        )
    }
}
