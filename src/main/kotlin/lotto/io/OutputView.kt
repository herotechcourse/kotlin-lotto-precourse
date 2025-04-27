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

    fun printWinningStatistics(map: Map<PrizeRank, Int>) {
        println("\nWinning Statistics\n---")
        for(result in map) {
            if(!PrizeRank.NONE.equals(result.key)) {
                print("${result.key.matchCount} Matches ")
                if(result.key.bonusResult) {
                    print("+ Bonus Ball ")
                }
                println("(${String.format("%,d", result.key.prize)} KRW) – ${result.value} tickets")
            }
        }
    }

    fun printProfitResult(total: String) {
        println("Total return rate is ${total}%.")
    }
}