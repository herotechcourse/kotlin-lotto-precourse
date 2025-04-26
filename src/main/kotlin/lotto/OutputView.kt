package lotto

object OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("\nYou have purchased ${tickets.size} tickets.")
        tickets.forEach {
            println(it.numbers.sorted())
        }
    }

    fun printResult(result: LottoResult) {
        println("\nWinning Statistics")
        println("---")
        Rank.entries.reversed().forEach { rank ->
            if (rank != Rank.NONE) {
                println("${rank.matchCount} Matches${rank.bonusBall?.let { " + Bonus Ball" } ?: ""} (${ "%,d".format(rank.prize) } KRW) – ${result.rankCount[rank]} tickets")
            }
        }
        println("Total return rate is ${"%.1f".format(result.rate)}%.")
    }
    
}
