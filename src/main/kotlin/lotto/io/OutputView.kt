package lotto.io

import lotto.Lotto
import lotto.domain.PrizeRank
import kotlin.collections.iterator

object OutputView {
    fun printUsertickets(userLottos :List<Lotto>) {
        println("\nYou have purchased ${userLottos.size} tickets.")
        for (userLotto in userLottos ) {
            println(userLotto.toString())
        }
    }

    fun printProfitResult(total: String) {
        println("Total return rate is ${total}%.")
    }

    fun printWinningStatistics(rankCountMap: Map<PrizeRank, Int>) {
        println("\nWinning Statistics\n---")
        for (result in rankCountMap) {
            if (result.key == PrizeRank.NONE) continue
            printSingleRank(result.key, result.value)
        }
    }

    private fun printSingleRank(rank: PrizeRank, count: Int) {
        print("${rank.matchCount} Matches ")
        if (rank.bonusResult) {
            print("+ Bonus Ball ")
        }
        println("(${String.format("%,d", rank.prize)} KRW) – ${count} tickets")
    }
}