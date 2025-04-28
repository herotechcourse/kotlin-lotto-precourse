package lotto

object OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach {
            println(it.getNumbers())
        }
    }

    fun printStatistics(stats: ResultStatistics, purchaseAmount: Int) {
        println("Lotto result statistics:")
        Rank.values().forEach { rank ->
            val label = when (rank) {
                Rank.FIRST  -> "6 Matches (${formatMoney(rank.prize)}) – %d tickets"
                Rank.SECOND -> "5 Matches + Bonus Ball (${formatMoney(rank.prize)}) – %d tickets"
                else        -> "${rank.matchCount} Matches (${formatMoney(rank.prize)}) – %d tickets"
            }
            println(label.format(stats.getCount(rank)))
        }
        val rate = stats.profitRate(purchaseAmount)
        println("Total return rate is ${"%.1f".format(rate)}%.")
    }

    private fun formatMoney(amount: Long): String =
        "%,d KRW".format(amount)
}
