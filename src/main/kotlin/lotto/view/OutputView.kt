package lotto.view

import lotto.Lotto
import lotto.domain.Rank
import java.util.Locale
import kotlin.math.round

object OutputView {
    fun printLottos(lottos: List<Lotto>) {
        println("\nYou have purchased ${lottos.size} tickets.")
        lottos.forEach { println(it) }
        println()
    }

    fun printWinningStatistics(rankCounts: Map<Rank, Int>, totalAmount: Int) {
        println("Winning Statistics")
        println("---")

        printSizeRanks(rankCounts)
        printReturnRate(rankCounts, totalAmount)
    }

    private fun printSizeRanks(rankCounts: Map<Rank, Int>) {
        for (rank in Rank.entries) {
            if (rank != Rank.NONE) {
                val count = rankCounts.getOrDefault(rank, 0)
                val ticketSuffix = "s"
                println("${rank.description} (${formatPrize(rank.prize)} KRW) \u2013 $count ticket$ticketSuffix")
            }
        }
    }

    private fun printReturnRate(rankCounts: Map<Rank, Int>, totalAmount: Int) {
        val totalPrize = calculateTotalPrize(rankCounts)
        val returnRate = calculateReturnRate(totalPrize, totalAmount)
        println("Total return rate is ${formatReturnRate(returnRate)}%.")
    }

    private fun calculateTotalPrize(rankCounts: Map<Rank, Int>): Long {
        return rankCounts.entries.sumOf { (rank, count) -> rank.prize * count }
    }

    private fun calculateReturnRate(totalPrize: Long, totalAmount: Int): Double {
        return totalPrize.toDouble() / totalAmount * 100
    }

    private fun formatPrize(prize: Long): String {
        return prize.toString().replace(Regex("(\\d)(?=(\\d{3})+$)"), "$1,")
    }

    private fun formatReturnRate(rate: Double): String {
        return String.format(Locale.US, "%.1f", round(rate * 10) / 10)
    }
}