package lotto.view

import lotto.Lotto
import lotto.domain.Rank
import lotto.domain.MatchResult

object OutputView {
    fun promptPurchaseAmount() {
        println("Please enter the purchase amount.")
    }

    fun promptWinningNumbers() {
        println()
        println("Please enter last week's winning numbers.")
    }

    fun promptBonusNumber() {
        println()
        println("Please enter the bonus number.")
    }

    fun printPurchaseLottos(lottos: List<Lotto>) {
        println()
        println("You have purchased ${lottos.size} tickets.")
        lottos.forEach { lotto ->
            println(lotto.getNumbers())
        }
    }

    fun printMatchResult(matchResult: MatchResult) {
        println()
        println("Winning Statistics")
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

    fun printError(message: String?) {
        println(message ?: "[ERROR] An unknown error occurred.")
    }

    // \u2013: (en dash) "–", not same with short hyphen ("-")
    private fun formatMatchResultLine(rank: Rank, count: Int): String {
        return "${rank.getDescription()} (${rank.prize.toKRWFormat()}) \u2013 ${count} tickets"
    }

    private fun Int.toKRWFormat(): String = "%,d KRW".format(this)
}
