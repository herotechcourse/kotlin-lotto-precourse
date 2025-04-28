package lotto

object OutputView {

    fun printPurchasedTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it) }
    }

    fun printWinningStatistics(statistics: Map<Prize, Int>, totalInvestment: Int, totalWinnings: Long) {
        println("\nWinning Statistics")
        println("---")
        Prize.entries.filter { it != Prize.NONE }.forEach { rank ->
            val count = statistics.getOrDefault(rank, 0)
            when (rank) {
                Prize.SECOND -> println("5 Matches + Bonus Ball (${formatCurrency(rank.prizeAmount)} KRW) – $count tickets")
                else -> println("${rank.matchCount} Matches (${formatCurrency(rank.prizeAmount)} KRW) – $count tickets")
            }
        }
        val returnRate = calculateReturnRate(totalWinnings, totalInvestment)
        println("Total return rate is ${returnRate}%.")
    }

    private fun formatCurrency(amount: Long): String {
        return amount.toString().replace(Regex("(\\d)(?=(\\d{3})+$)"), "$1,")
    }

    private fun calculateReturnRate(totalWinnings: Long, totalInvestment: Int): String {
        val rate = totalWinnings.toDouble() / totalInvestment.toDouble() * 100.0
        return String.format("%.1f", rate)
    }

}