package lotto.view

import lotto.Lotto
import lotto.domain.Rank
import lotto.domain.MatchResult

object OutputView {
    fun printPurchaseLottos(lottos: List<Lotto>) {
        println("You have purchased ${lottos.size} tickets.")
        lottos.forEach { lotto ->
            println(lotto.getNumbers())
        }
    }

    fun printMatchResult(matchResult: MatchResult) {
        println("\nWinning Statistics")
        println("---")
        Rank.entries
            .filter { it != Rank.MISS }
            .sortedBy { it.prize }
            .forEach { rank ->
                println(formatMatchResultLine(rank, matchResult.getCount(rank)))
            }
    }

    fun printProfitRate(profitRate: Double) {
        println("Total return rate is ${profitRate}%.")
    }

    // \u2013: (en dash) "–", not same with short hyphen ("-")
    private fun formatMatchResultLine(rank: Rank, count: Int): String {
        return "${rank.getDescription()} (${rank.prize.toKRWFormat()}) \u2013 ${count} tickets"
    }

    private fun Int.toKRWFormat(): String = "%,d KRW".format(this)
}
