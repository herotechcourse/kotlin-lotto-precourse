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
        println("\nWinning Statistics")
        println("---")

        printResultLine(LottoResult.FIFTH, results)
        printResultLine(LottoResult.FOURTH, results)
        printResultLine(LottoResult.THIRD, results)
        printResultLine(LottoResult.SECOND, results)
        printResultLine(LottoResult.FIRST, results)

        val roundedRate = round(profitRate * 10) / 10
        println("Total return rate is ${roundedRate}%.")
    }

    private fun printResultLine(result: LottoResult, results: Map<LottoResult, Int>) {
        val count = results[result] ?: 0
        val description = when (result) {
            LottoResult.SECOND -> "5 Matches + Bonus Ball (${formatPrize(result.prize)})"
            else -> "${result.matchCount} Matches (${formatPrize(result.prize)})"
        }
        println("$description – $count tickets")
    }

    private fun formatPrize(prize: Int): String {
//        return "$prize KRW"
        return "${String.format("%,d", prize)} KRW"
    }
}