package lotto.view

import lotto.config.LottoConstants.EN_DASH
import lotto.config.LottoConstants.TICKETS
import lotto.domain.model.Lotto
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
        println(Rank.FIFTH.message + EN_DASH + winResult.getResult()[Rank.FIFTH] + TICKETS)
        println(Rank.FOURTH.message + EN_DASH + winResult.getResult()[Rank.FOURTH] + TICKETS)
        println(Rank.THIRD.message + EN_DASH + winResult.getResult()[Rank.THIRD] + TICKETS)
        println(Rank.SECOND.message + EN_DASH + winResult.getResult()[Rank.SECOND] + TICKETS)
        println(Rank.FIRST.message + EN_DASH + winResult.getResult()[Rank.FIRST] + TICKETS)
    }
}