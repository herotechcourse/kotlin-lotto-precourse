package lotto.view

import lotto.Lotto
import lotto.Prize
import java.text.NumberFormat
import java.util.Locale

object OutputView {
    fun printPurchasedLottos(lottos: List<Lotto>) {
        println("\nYou have purchased ${lottos.size} tickets.")
        lottos.forEach { println(it) }
    }

    fun printStatistics(results: Map<Prize, Int>, roi: Double) {
        println("\nWinning Statistics")
        println("---")
        Prize.entries.filter {it != Prize.MISS}.sortedBy {it.reward}.forEach { prize ->
            val count = results.getOrDefault(prize, 0)
            val rewardFormatted = formatCurrency(prize.reward)
            println("${prize.description} (${rewardFormatted} KRW) – ${count} tickets")
        }
        println("Total return rate is ${roi}%.")
    }

    private fun formatCurrency(amount: Long): String {
        return NumberFormat.getNumberInstance(Locale.KOREA).format(amount)
    }
}