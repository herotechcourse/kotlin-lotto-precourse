package lotto.view

import lotto.model.Lotto
import lotto.model.LottoResult
import lotto.model.Rank
import java.text.DecimalFormat

class OutputView {

    fun printLottos(lottos: List<Lotto>) {
        println()
        println("You have purchased ${lottos.size} tickets.")

        lottos.forEach { lotto ->
            println(lotto)
        }
        println()
    }

    fun printResults(result: LottoResult) {
        println("Winning Statistics")
        println("---")

        printRankStatistics(result)
    }

    private fun printRankStatistics(result: LottoResult) {
        val ranks = listOf(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST)

        ranks.forEach { rank ->
            val count = result.getRankCount(rank)
            println("${rank.description} (${formatMoney(rank.prize)} KRW) – ${count} tickets")
        }
    }

    fun printProfitRate(profitRate: Double) {
        val formatter = DecimalFormat("#,##0.0")
        println("Total return rate is ${formatter.format(profitRate)}%.")
    }

    fun printError(message: String) {
        println(message)
    }

    private fun formatMoney(amount: Long): String {
        return DecimalFormat("#,###").format(amount)
    }
}