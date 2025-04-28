package lotto.view

import lotto.Lotto
import lotto.PrizeRank

object OutputView {

    private const val LOTTO_TICKETS_MESSAGE = "\nYou have purchased %d tickets."
    private const val LOTTO_STATISTICS_MESSAGE =
        """
Winning Statistics
---"""
    private const val LOTTO_MATCH_MESSAGE = "%d Matches (%,d KRW) – %d tickets"
    private const val LOTTO_MATCH_WITH_BONUS_BALL_MESSAGE = "%d Matches + Bonus Ball (%,d KRW) – %d tickets"
    private const val LOTTO_PROFIT_RATE_MESSAGE = "Total return rate is %,.1f%%."

    fun showLottoTickets(lottoTickets: List<Lotto>) {
        println(LOTTO_TICKETS_MESSAGE.format(lottoTickets.size))
        lottoTickets.forEach { lotto ->
            println(lotto.numbers().map { it.value })
        }
    }

    fun showWinningStatistics(result: Map<PrizeRank, Int>, profitRate: Double) {
        println(LOTTO_STATISTICS_MESSAGE)
        result.entries
            .drop(1)
            .reversed()
            .forEach { showMatchStatistic(it) }
        println(LOTTO_PROFIT_RATE_MESSAGE.format(profitRate))
    }

    private fun showMatchStatistic(entry: Map.Entry<PrizeRank, Int>) {
        if (entry.key == PrizeRank.SECOND) {
            println(
                LOTTO_MATCH_WITH_BONUS_BALL_MESSAGE.format(
                    entry.key.matchingCount, entry.key.prizeAmount, entry.value
                )
            )
        }
        if (entry.key != PrizeRank.SECOND) {
            println(LOTTO_MATCH_MESSAGE.format(entry.key.matchingCount, entry.key.prizeAmount, entry.value))
        }
    }

    fun printError(message: String) {
        println(message)
    }
}
