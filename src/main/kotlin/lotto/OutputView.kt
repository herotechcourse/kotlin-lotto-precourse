package lotto

import lotto.LottoMachine.PrizeRank

class OutputView {
    //Print the generated lotto tickets
    fun PrintLottoTickets(tickets: List<List<Int>>, numberOfTickets: Int) {
        println("You have purchased $numberOfTickets tickets.")
        for (ticket in tickets) {
            println(ticket)
        }
    }

    //Print the prizes and the number of tickets in for that prize
    fun PrintPrizeRanks(rankStats: MutableMap<LottoMachine.PrizeRank, Int>) {
        listOf(PrizeRank.Rank5, PrizeRank.Rank4, PrizeRank.Rank3, PrizeRank.Rank2, PrizeRank.Rank1).forEach { rank ->
            val count = rankStats.getOrDefault(rank, 0)
            println("${rank.description} – $count tickets")
        }
    }

    //Print the total return rate
    fun PrintReturnRate(profit: Double) {
        print("Total return rate is $profit%.")
    }
}