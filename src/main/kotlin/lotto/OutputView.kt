package lotto

object OutputView {

    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")

        tickets.forEach {ticket ->
            val sortedNumbers = ticket.getNumbers().sorted()
            println(sortedNumbers)
        }
    }

    fun printStatistics(statistics: Map<LottoRank, Int>) {
        println("Winning Statistics")
        println("---")
        getSortedRanks()
            .forEach { rank ->
                val count = statistics.getOrDefault(rank, 0)
                println("${rank.prizeString} (${formatPrize(rank.prize)} KRW) – $count tickets")
            }
    }

    private fun getSortedRanks(): List<LottoRank> {
        return LottoRank.entries
            .filter { it != LottoRank.NONE }
            .sortedBy { it.matchCount }
    }

    private fun formatPrize(prize: Int): String {
        return "%,d".format(prize)
    }

    fun printReturnRate(returnRate: Double) {
        println("Total return rate is %.1f%%.".format(returnRate))
    }
}
