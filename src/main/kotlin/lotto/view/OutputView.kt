package lotto.view

import lotto.model.MatchRank
import lotto.model.MatchResults

class OutputView {
    fun printPurchaseLottos(allLottoNumbers: List<List<Int>>) {
        println("\nYou have purchased ${allLottoNumbers.size} tickets.")
        allLottoNumbers.forEach {
            println(it)
        }
    }

    fun printMatchResults(matchResults: MatchResults) {
        println("\nWinning Statistics")
        println("---")

        printRankResult(matchResults)

        println("Total return rate is ${String.format("%,.1f", matchResults.profitRate() * 100)}%.")
    }

    private fun printRankResult(matchResults: MatchResults) {
        for (rank in MatchRank.ranksInDisplayOrder()) {
            val count = matchResults.countOf(rank)
            println("${rank.toMessage()} – $count tickets")
        }
    }
}