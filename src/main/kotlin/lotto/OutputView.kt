package lotto

object OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it.getNumbers()) }
    }

    fun printResult(result: Result) {
        println("Winning Statistics")
        println("---")
        Rank.values()
            .filter { it != Rank.NONE }
            .sortedByDescending { it }
            .forEach { rank ->
                println("${rank.matchCount} Matches${if (rank.hasBonus) " + Bonus Ball" else ""} (${rank.prize} KRW) – ${result.getCount(rank)} tickets")
            }
        println("Total return rate is ${"%.1f".format(result.getRate())}%.")
    }
}
