package lotto.view

import lotto.config.LottoConstants.EN_DASH
import lotto.config.LottoConstants.TICKETS
import lotto.Lotto
import lotto.domain.model.Rank
import lotto.domain.service.WinResult

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
        for ((rank, count) in winResult.getResult()) {
            if (rank != Rank.NONE) {
                println("${rank.message}$EN_DASH$count$TICKETS")
            }
        }
    }
}