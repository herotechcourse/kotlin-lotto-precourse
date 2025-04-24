package lotto.view

import lotto.Lottos
import lotto.Rank
import java.text.NumberFormat
import java.util.*

object OutputView {

    private val numberFormatter = NumberFormat.getNumberInstance(Locale.US)

    private const val PROFIT_RATE_FORMAT = "%.1f"

    fun printLottos(lottos: Lottos) {
        println("\nYou have purchased ${lottos.size()} tickets.")
        lottos.getValues()
            .map { it.getNumbers().sorted() }
            .forEach { println(it) }
    }

    fun printFinalReport(rankCounts: Map<Rank, Int>, profitRate: Double) {
        printStatistics(rankCounts)
        printProfitRate(profitRate)
    }

    private fun printStatistics(rankCounts: Map<Rank, Int>) {
        println("\nWinning Statistics\n---")
        Rank.entries
            .filter { it != Rank.NONE }
            .sortedBy { it.prize }
            .map { it.toStatisticsLine(rankCounts) }
            .forEach(::println)
    }

    private fun Rank.toStatisticsLine(rankCounts: Map<Rank, Int>): String {
        val count = rankCounts[this] ?: 0
        val formattedPrize = numberFormatter.format(this.prize)
        val bonusInfo = if (this == Rank.SECOND) "+ Bonus Ball " else ""

        return "${this.matchCount} Matches $bonusInfo(${formattedPrize} KRW) – $count tickets"
    }

    private fun printProfitRate(profitRate: Double) {
        val formatted = PROFIT_RATE_FORMAT.format(profitRate)

        println("Total return rate is $formatted%.")
    }
}
