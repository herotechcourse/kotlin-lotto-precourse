package lotto

import lotto.domain.Lotto
import lotto.domain.Rank
import lotto.domain.Statistics
import lotto.domain.WinResult

class OutputHandler {
    fun printLotties(lotties: List<Lotto>) {
        println("You have purchased ${lotties.size} tickets.")
        for (lotto in lotties) {
            println(lotto.toString())
        }
    }

    fun printStatistics(winResult: WinResult, returnRate: Double) {
        println("Winning Statistics")
        println("---")
        printWinningResult(winResult)
        println("Total return rate is ${returnRate}%.")
    }

    private fun printWinningResult(winResult: WinResult) {
        println(Rank.FIFTH.message + " – " + winResult.getResult()[Rank.FIFTH]+ " tickets")
        println(Rank.FOURTH.message + " – " + winResult.getResult()[Rank.FOURTH]+ " tickets")
        println(Rank.THIRD.message + " – " + winResult.getResult()[Rank.THIRD]+ " tickets")
        println(Rank.SECOND.message + " – " + winResult.getResult()[Rank.SECOND]+ " tickets")
        println(Rank.FIRST.message + " – " + winResult.getResult()[Rank.FIRST]+ " tickets")
    }
}