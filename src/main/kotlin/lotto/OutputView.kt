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
        val sortedRanks = Rank.values().sortedBy { it.matchCount }

        sortedRanks.forEach { rank ->
            val count = results[rank] ?: 0
            when (rank) {
                Rank.SECOND -> println("5 Matches + Bonus Ball (${rank.prize} KRW) – $count tickets")
                Rank.THIRD -> println("5 Matches (${rank.prize} KRW) – $count tickets")
                Rank.FOURTH -> println("4 Matches (${rank.prize} KRW) – $count tickets")
                Rank.FIFTH -> println("3 Matches (${rank.prize} KRW) – $count tickets")
                Rank.FIRST -> println("6 Matches (${rank.prize} KRW) – $count tickets")
            }
        }
    }

    fun printProfitRate(profitRate: Double) {
        println("Total return rate is %.1f%%.".format(profitRate))
    }
}
