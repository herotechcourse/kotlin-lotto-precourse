package lotto.view

import lotto.Lotto
import lotto.Rank
import java.util.*

object OutputView {

    fun printLottos(lottos: List<Lotto>) {
        println("You have purchased ${lottos.size} tickets.")
        lottos.forEach { lotto ->
            println(lotto.getNumbers())
        }
    }

    fun printStatistics(result: Map<Rank, Int>, profitRate: Double) {
        println()
        println("Winning Statistics")
        println("---")

        Rank.values()
            .filter { it != Rank.NONE }
            .sortedBy { it.prizeMoney }
            .forEach { rank ->
                println("${getRankDescription(rank)} – ${result.getOrDefault(rank, 0)} tickets")
            }

        println("Total return rate is ${String.format(Locale.US, "%.1f", profitRate)}%.")
    }


    private fun getRankDescription(rank: Rank): String {
        return when (rank) {
            Rank.FIRST -> "6 Matches (2,000,000,000 KRW)"
            Rank.SECOND -> "5 Matches + Bonus Ball (30,000,000 KRW)"
            Rank.THIRD -> "5 Matches (1,500,000 KRW)"
            Rank.FOURTH -> "4 Matches (50,000 KRW)"
            Rank.FIFTH -> "3 Matches (5,000 KRW)"
            Rank.NONE -> ""
        }
    }
}
