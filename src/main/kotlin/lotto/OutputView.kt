package lotto

object OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("\nYou have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it.getNumbers()) }
    }

    fun printResult(result: Map<Rank, Int>) {
        println("\nWinning Statistics\n---")
        Rank.entries
            .filter { it != Rank.NONE }
            .sortedByDescending { it.prize }
            .forEach { rank ->
                println("${rank.description()} - ${result[rank] ?: 0} ticket(s)")
            }
    }

    fun printReturnRate(result: Map<Rank, Int>, purchaseAmount: Int) {
        val totalPrize = result.entries.sumOf { it.key.prize.toLong() * it.value }
        val rate = totalPrize * 100.0 / purchaseAmount
        println("Total return rate is ${"%.1f".format(rate)}%.")
    }
}
