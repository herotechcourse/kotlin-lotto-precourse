package lotto

import lotto.LottoMachine.PrizeRank

class OutputView {
    fun PrintLottoTickets(tickets: List<List<Int>>, numberOfTickets: Int) {
        println("Number of tickets issued and their numbers (sorted in ascending order):")
        println("You have purchased $numberOfTickets tickets.")
        for (ticket in tickets) {
            println(ticket)
        }
    }

    fun PrintPrizeRanks(rankStats: MutableMap<LottoMachine.PrizeRank, Int>) {
        listOf(PrizeRank.Rank5, PrizeRank.Rank4, PrizeRank.Rank3, PrizeRank.Rank2, PrizeRank.Rank1).forEach { rank ->
            val count = rankStats.getOrDefault(rank, 0)
            println("${rank.description} – $count tickets")
        }
    }

    fun PrintReturnRate(profit: Double) {
        print("Total return rate is $profit%.")
    }
}