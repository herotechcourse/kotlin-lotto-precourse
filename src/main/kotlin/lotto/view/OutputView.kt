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
        sortedCountOfRanks.forEach { countOfRank ->
            val rank = countOfRank.key
            println("%d Matches (%,d KRW) - %d ticket".format(rank.countOfMatch, rank.winningMoney, countOfRank.value))
        }
    }

    fun printReturnRate(returnRate: Float) {
        println("Total return rate is %.1f%%.".format(returnRate))
    }
}
