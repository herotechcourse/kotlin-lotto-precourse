package lotto.view

import lotto.Lotto
import lotto.model.Rank

class OutputView {
    fun printUserLottos(userLottos: List<Lotto>) {
        println(MESSAGE_USER_LOTTOS.format(userLottos.size))
        userLottos.forEach { userLotto ->
            println(userLotto.numbers.sorted())
        }
    }

    fun printWinningStatistics(countOfRanks: Map<Rank, Int>) {
        println(MESSAGE_WINNING_STATISTICS)
        println(MESSAGE_SPLIT_LINE)
        val sortedCountOfRanks = countOfRanks.entries.sortedBy { it.key.winningMoney }
        for (countOfRank in sortedCountOfRanks) {
            val rank = countOfRank.key
            if (rank == Rank.SECOND) {
                println(MESSAGE_WINNING_TABLE_SECOND_OR_THIRD.format(rank.countOfMatch, rank.winningMoney, countOfRank.value))
                continue
            }
            println(MESSAGE_WINNING_TABLE.format(rank.countOfMatch, rank.winningMoney, countOfRank.value))
        }
    }

    fun printReturnRate(returnRate: Float) {
        println(MESSAGE_RETURN_RATE.format(returnRate))
    }

    companion object {
        private const val MESSAGE_USER_LOTTOS = "You have purchased %d tickets."
        private const val MESSAGE_WINNING_STATISTICS = "Winning Statistics"
        private const val MESSAGE_SPLIT_LINE = "---"
        private const val MESSAGE_WINNING_TABLE_SECOND_OR_THIRD = "%d Matches + Bonus Ball (%,d KRW) – %d tickets"
        private const val MESSAGE_WINNING_TABLE = "%d Matches (%,d KRW) – %d tickets"
        private const val MESSAGE_RETURN_RATE = "Total return rate is %.1f%%."
    }
}
