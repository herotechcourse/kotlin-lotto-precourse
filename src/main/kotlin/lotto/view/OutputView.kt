package lotto.view

import lotto.Lotto
import lotto.Rank
import lotto.WinningResult
import java.util.Locale

object OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it) }
    }

    fun printResult(result: WinningResult, purchaseAmount: Int) {
        println("Lotto result statistics:")
        Rank.values()
            .sortedWith(compareBy({ it.match }, { it.bonusRequired }))
            .forEach { rank ->
                val count = result.rankCounts[rank] ?: 0
                val label = if (rank == Rank.SECOND) "5 Matches + Bonus Ball" else "${rank.match} Matches"
                val formattedPrize = String.format(Locale.US, "%,d KRW", rank.prize)
                println("$label ($formattedPrize) – $count tickets")
            }
        val rate = result.totalPrize.toDouble() / purchaseAmount * 100
        println(String.format(Locale.US, "Total return rate is %.1f%%.", rate))
    }
}


