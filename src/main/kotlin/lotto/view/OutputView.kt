package lotto.view

import lotto.Lotto
import lotto.domain.Lottoes
import lotto.domain.LottoResult
import lotto.domain.Rank

object OutputView {

    private fun formatPrize(prize: Int): String {
        return "%,d KRW".format(prize)
    }

    private fun formatPercentage(rate: Double): String {
        return "%,.1f".format(rate)
    }

    fun printLottoes(lottoes: Lottoes) {
        println("\nYou have purchased ${lottoes.size()} tickets.")
        lottoes.getTickets().forEach {
            println(it.getNumbers())
        }
    }

    fun printResult(result: LottoResult, purchaseAmount: Int) {
        println("\nWinning Statistics")
        println("---")
        Rank.entries
            .filter { it != Rank.NONE }
            .sortedByDescending { it.prize }
            .forEach {
                val matchText = when (it) {
                    Rank.SECOND -> "5 Matches + Bonus Ball"
                    else -> "${it.matchCount} Matches"
                }
                val prizeText = formatPrize(it.prize)
                val count = result.countOf(it)
                println("$matchText ($prizeText) – $count tickets")
            }

        val profitText = formatPercentage(result.profitRate(purchaseAmount))
        println("Total return rate is $profitText%.")
    }
}