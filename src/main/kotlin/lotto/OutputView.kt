package lotto

object OutputView {
    fun printTickets(tickets:  MutableList<Set<Int>> ) {
        println("You have purchased ${tickets.size} tickets.")
        for(ticket in tickets) {
            println(ticket)
        }
    }

    fun printError(message: String) {
        println("\u001B[31mError: $message\u001B[0m")
    }

    fun printResults(results: Map<PrizeRank, Int>, totalSpent: Int) {
        val totalWon = results.entries.sumOf { it.key.amount * it.value }

        val orderedRanks = listOf(
            PrizeRank.FIFTH,
            PrizeRank.FOURTH,
            PrizeRank.THIRD,
            PrizeRank.SECOND,
            PrizeRank.FIRST
        )
        for (rank in orderedRanks) {
            val count = results[rank] ?: 0
            println("${rank.display} – $count tickets")
        }

        println("Total return rate is ${(totalWon.toDouble() / totalSpent * 100).format(2)}.")
    }

    private fun Double.format(decimals: Int) =
        "%.${decimals}f%%".format(this)
}