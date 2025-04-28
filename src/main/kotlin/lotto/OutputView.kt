// src/main/kotlin/lotto/OutputView.kt
package lotto

import java.util.Locale

object OutputView {
    /** Prints the number of purchased tickets */
    fun printPurchase(count: Int) {
        println("You have purchased $count tickets.")
    }

    /** Prints each Lotto ticket (sorted) */
    fun printTickets(tickets: List<Lotto>) {
        tickets.forEach { ticket ->
            println(ticket.sortedNumbers())
        }
    }

    /** Prints statistics and return rate */
    fun printStatistics(statistics: LottoStatistics) {
        println("Lotto result statistics:")
        val order = listOf(
            LottoRank.FIFTH,
            LottoRank.FOURTH,
            LottoRank.THIRD,
            LottoRank.SECOND,
            LottoRank.FIRST
        )
        order.forEach { rank ->
            val count = statistics.countByRank()[rank] ?: 0
            val label = when (rank) {
                LottoRank.FIFTH  -> "3 Matches"
                LottoRank.FOURTH -> "4 Matches"
                LottoRank.THIRD  -> "5 Matches"
                LottoRank.SECOND -> "5 Matches + Bonus Ball"
                LottoRank.FIRST  -> "6 Matches"
                else             -> ""
            }
            // 천 단위 콤마 포맷과 en-dash 적용
            val prizeFormatted = String.format(Locale.US, "%,d", rank.prize)
            println("$label ($prizeFormatted KRW) – $count tickets")
        }
        println("Total return rate is ${statistics.returnRate()}%.")
    }
}
