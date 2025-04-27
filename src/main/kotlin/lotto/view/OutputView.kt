package lotto.view

import lotto.Lotto
import lotto.model.Rank

class OutputView {
    fun printUserLottos(userLottos: List<Lotto>) {
        println("You have purchased %d tickets.".format(userLottos.size))
        userLottos.forEach { userLotto ->
            println(userLotto.numbers.sorted())
        }
    }

    fun printWinningStatistics(countOfRanks: Map<Rank, Int>) {
        println("Winning Statistics")
        println("---")
        val sortedCountOfRanks = countOfRanks.entries.sortedBy { it.key.winningMoney }
        for (countOfRank in sortedCountOfRanks) {
            val rank = countOfRank.key
            if (rank == Rank.SECOND) {
                println("%d Matches + Bonus Ball (%,d KRW) – %d tickets".format(rank.countOfMatch, rank.winningMoney, countOfRank.value))
                continue
            }
            println("%d Matches (%,d KRW) – %d tickets".format(rank.countOfMatch, rank.winningMoney, countOfRank.value))
        }
    }

    fun printReturnRate(returnRate: Float) {
        println("Total return rate is %.1f%%.".format(returnRate))
    }
}
