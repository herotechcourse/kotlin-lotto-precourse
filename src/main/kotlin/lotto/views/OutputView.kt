package lotto.views

import lotto.Lotto
import lotto.LottoResult
import lotto.Rank
import java.util.Locale

object OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it) }
    }

    fun printStatistics(result: LottoResult, purchaseAmount: Int) {
        println("Winning Statistics")
        println("---")

        val counts = result.getRankCounts()

        println("3 Matches (5,000 KRW) – ${counts.getOrDefault(Rank.FIFTH, 0)} tickets")
        println("4 Matches (50,000 KRW) – ${counts.getOrDefault(Rank.FOURTH, 0)} tickets")
        println("5 Matches (1,500,000 KRW) – ${counts.getOrDefault(Rank.THIRD, 0)} tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – ${counts.getOrDefault(Rank.SECOND, 0)} tickets")
        println("6 Matches (2,000,000,000 KRW) – ${counts.getOrDefault(Rank.FIRST, 0)} tickets")

        val totalPrize = result.totalPrize()
        val profitRate = totalPrize.toDouble() / purchaseAmount * 100
        val rounded = String.format(Locale.US, "%.1f", profitRate)

        println("Total return rate is $rounded%.")
    }
}