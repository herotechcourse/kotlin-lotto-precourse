package lotto

object OutputView {
    fun printPurchasedTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { ticket ->
            println(ticket.getNumbers())
        }
    }

    fun printResultStatistics(results: Map<Rank, Int>) {
        println()
        println("Winning Statistics")
        println("---")

        // Sort by minimum number of matches required (smallest first)
        val sortedRanks = Rank.entries.sortedBy { it.matchCount }

        sortedRanks.forEach { rank ->
            val count = results[rank] ?: 0
            when (rank) {
                Rank.SECOND -> println("5 Matches + Bonus Ball (${formatMoney(rank.prize)} KRW) – $count tickets")
                Rank.THIRD -> println("5 Matches (${formatMoney(rank.prize)} KRW) – $count tickets")
                Rank.FOURTH -> println("4 Matches (${formatMoney(rank.prize)} KRW) – $count tickets")
                Rank.FIFTH -> println("3 Matches (${formatMoney(rank.prize)} KRW) – $count tickets")
                Rank.FIRST -> println("6 Matches (${formatMoney(rank.prize)} KRW) – $count tickets")
            }
        }
    }

    fun printProfitRate(profitRate: Double) {
        println("Total return rate is %.1f%%.".format(profitRate))
    }

    private fun formatMoney(amount: Int): String {
        return "%,d".format(amount)
    }

}
