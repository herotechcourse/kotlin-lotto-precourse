package lotto

import kotlin.math.round

class OutputView {
    fun printPurchasedLottos(lottos: List<Lotto>) {
        println("\nYou have purchased ${lottos.size} tickets.")
        lottos.forEach { lotto ->
            println(lotto.getSortedNumbers())
        }
        println()
    }

    fun printResults(results: Map<LottoResult, Int>, profitRate: Double) {
        println("\nWinning Statistics\n---")
        printStatistics(results)
        val roundedRate = round(profitRate * 10) / 10
        println("Total return rate is ${roundedRate}%.")
    }

    private fun printStatistics(results: Map<LottoResult, Int>) {
        listOf(
            LottoResult.FIFTH,
            LottoResult.FOURTH,
            LottoResult.THIRD,
            LottoResult.SECOND,
            LottoResult.FIRST
        ).forEach { printResultLine(it, results) }
    }

    private fun printResultLine(result: LottoResult, results: Map<LottoResult, Int>) {
        val count = results[result] ?: 0
        if (result == LottoResult.SECOND) {
            println("5 Matches + Bonus Ball (${formatPrize(result.prize)}) – $count tickets")
            return
        }
        println("${result.matchCount} Matches (${formatPrize(result.prize)}) – $count tickets")
    }

    private fun formatPrize(prize: Int): String {
        return "${String.format("%,d", prize)} KRW"
    }
}