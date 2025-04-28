package lotto.view

import lotto.Lotto
import lotto.LottoRank
import lotto.LottoResult
import java.text.DecimalFormat

object OutputView {
    fun printPurchasedLottos(lottos: List<Lotto>) {
        println("\nYou have purchased ${lottos.size} tickets.")
        lottos.forEach { println(it.getNumbers()) }
    }

    fun printResult(lottoResult: LottoResult) {
        val results = lottoResult.getResults()
        val profitRate = lottoResult.calculateProfitRate()
        printWinningStatistics(results, profitRate)
    }

    private fun printWinningStatistics(results: Map<LottoRank, Int>, profitRate: Double) {
        printWinningHeader()
        printRankResults(results)
        printProfitRate(profitRate)
    }

    private fun printWinningHeader() {
        println("\nWinning Statistics")
        println("---")
    }

    private fun printRankResults(results: Map<LottoRank, Int>) {
        // Print ranks in ascending order of prize (5th to 1st)
        LottoRank.entries
            .filter { it != LottoRank.MISS }
            .sortedBy { it.prize }
            .forEach { rank ->
                val count = results.getOrDefault(rank, 0)
                val description = getRankDescription(rank)

                if (description.isNotEmpty()) {
                    println("${description} – ${count} tickets")
                }
            }
    }

    private fun getRankDescription(rank: LottoRank): String {
        return rank.getFormattedDescription()
    }

    private fun printProfitRate(profitRate: Double) {
        // Format to one decimal place
        val format = DecimalFormat("#,##0.0")
        println("Total return rate is ${format.format(profitRate)}%.")
    }
} 