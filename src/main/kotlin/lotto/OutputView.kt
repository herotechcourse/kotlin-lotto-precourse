package lotto

object OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it.getNumbers()) }

    }

    fun printStatistics(result: Map<PrizeRank, Int>, spent: Int) {
        println("Winning Statistics")
        println("---")
        PrizeRank.values().sortedBy { it.rank }.forEach {
            val count = result[it] ?: 0
            println("${it.description} – $count tickets")
        }
        val earnings = result.entries.sumOf { it.key.prize * it.value }
        val rate = (earnings.toDouble() / spent) * 100
        println("Total return rate is ${"%.1f".format(rate)}%.")
    }
}
