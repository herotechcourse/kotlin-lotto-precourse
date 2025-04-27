package lotto

import java.text.NumberFormat
import java.util.Locale

object OutputView {
    fun printLottos(lottos: List<Lotto>) {
        println("You have purchased ${lottos.size} tickets.")
        lottos.forEach {
            println(it.getNumbers())
        }
    }

    fun printResult(result: LottoResult) {
        println("Winning Statistics")
        println("---")
        val numberFormat = NumberFormat.getInstance(Locale.US)
        LottoRank.entries
            .filter { it != LottoRank.NONE }
            .reversed()
            .forEach { rank ->
                val bonusText = if (rank.hasBonus) " + Bonus Ball" else ""
                val prizeFormatted = numberFormat.format(rank.prize)
                val count = result.rankCount[rank] ?: 0
                val countFormatted = numberFormat.format(count)
                println("${rank.matchCount} Matches$bonusText ($prizeFormatted KRW) – $countFormatted tickets")
            }
        val rateFormatted = numberFormat.format(result.rate)
        println("Total return rate is $rateFormatted%.")
    }
}