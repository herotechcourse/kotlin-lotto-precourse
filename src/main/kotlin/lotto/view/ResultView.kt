package lotto.view

import lotto.domain.ProfitCalculator
import lotto.domain.Rank
import lotto.domain.WinningResult

class ResultView {

    fun printStatistics(result: WinningResult, purchaseAmount: Int) {
        println("Winning Statistics")
        println("---")

        Rank.values()
            .filter { it != Rank.NONE }
            .sortedByDescending { it.prize }
            .forEach { rank ->
                val matchText = formatMatchText(rank)
                val count = result.getCountOf(rank)
                println("$matchText (${formatCurrency(rank.prize)} KRW) – $count tickets")
            }

        val profitRate = ProfitCalculator.calculate(result.getStatistics(), purchaseAmount)
        println("Total return rate is ${"%.1f".format(profitRate)}%.")
    }

    private fun formatMatchText(rank: Rank): String {
        if (rank.matchBonus) {
            return "${rank.matchCount} Matches + Bonus Ball" //PRIZE_SECOND case
        }
        return "${rank.matchCount} Matches"
    }

    private fun formatCurrency(amount: Int): String {
        return "%,d".format(amount)
    }
}
