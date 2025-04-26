package lotto

import java.util.*

object OutputView {
    fun printPurchasedTickets(amount: Int, tickets: List<Lotto>) {
        if (amount <= 0) throw IllegalArgumentException("Amount must be neither of negative or 0.")

        println("You have purchased $amount tickets.")
        repeat(tickets.size) {
            println(tickets[it].getNumbers().sorted())
        }
    }

    fun printResultStatistics(countRanks: Map<LottoRank, Int>, profitRate: String) {
        println("Winning Statistics")
        println("---")

        printPrizeResult(countRanks)
        printProfitRate(profitRate)

    }

    private fun printPrizeResult(countRanks: Map<LottoRank, Int>) {
        LottoRank.entries.sortedBy { it.prize }.filter {
            it != LottoRank.NONE
        }.forEach { rank ->
            val matchCount = rank.matchCount
            val prize = String.format(Locale.KOREA, "%,d KRW", rank.prize)
            val bonusText = if (rank == LottoRank.SECOND) "+ Bonus Ball " else ""
            val matchTickets = countRanks[rank] ?: 0

            println("$matchCount Matches $bonusText($prize) – $matchTickets tickets")
        }
    }


    private fun printProfitRate(profitRate: String) {
        println("Total return rate is $profitRate.")
    }
}
