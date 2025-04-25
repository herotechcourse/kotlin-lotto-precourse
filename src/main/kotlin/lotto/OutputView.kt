package lotto

object OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("\nYou bought ${tickets.size} tickets:")
        tickets.forEach { println(it.numbers.sorted()) }
    }

    fun printResults(result: Map<Rank, Int>, amount: Int) {
        println("\nResults:")
        Rank.values().filter { it != Rank.NONE }.forEach {
            val count = result[it] ?: 0
            println("${it.matchText} - $count matches")
        }
        val profitRate = LottoResult.calculateProfit(result, amount)
        println("\nTotal profit rate: ${"%.2f".format(profitRate)}")
    }
}
