package lotto

object OutputView {
    fun displayTickets(tickets: List<Lotto>) {
        println("\nYou have purchased ${tickets.size} tickets.")
        tickets.forEach { ticket ->
            println(ticket.getNumbers().sorted())
        }
    }

    fun displayResults(result: Result) {
        println("\nWinning Statistics")
        println("–––")
        displayWinCounts(result.getWinCounts())
        println("Total return rate is ${result.getProfitRate()}%.")
    }

    fun displayWinCounts(winCounts: Map<Rank, Int>) {
        println("3 Matches (5,000 KRW) – ${winCounts[Rank.FIFTH]} tickets")
        println("4 Matches (50,000 KRW) – ${winCounts[Rank.FOURTH]} tickets")
        println("5 Matches (1,500,000 KRW) – ${winCounts[Rank.THIRD]} tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – ${winCounts[Rank.SECOND]} tickets")
        println("6 Matches (2,000,000,000 KRW) – ${winCounts[Rank.FIRST]} tickets")
    }
}