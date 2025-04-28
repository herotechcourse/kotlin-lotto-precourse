package lotto

class OutputView {
    fun displayPurchasedTickets(tickets: List<LottoTicket>) {
        println("\nYou have purchased ${tickets.size} ${if (tickets.size == 1) "ticket" else "tickets"}.")
        tickets.forEach { println(it.numbers.sorted()) }
        println()
    }

    fun displayWinningStatistics(results: Map<Prize, Int>, purchaseAmount: Int) {
        println("\nWinning Statistics")
        println("---")
        println("3 Matches (${Prize.FIFTH.prizeMoney} KRW) – ${results[Prize.FIFTH] ?: 0} tickets")
        println("4 Matches (${Prize.FOURTH.prizeMoney} KRW) – ${results[Prize.FOURTH] ?: 0} tickets")
        println("5 Matches (${Prize.THIRD.prizeMoney} KRW) – ${results[Prize.THIRD] ?: 0} tickets")
        println("5 Matches + Bonus Ball (${Prize.SECOND_BONUS.prizeMoney} KRW) – ${results[Prize.SECOND_BONUS] ?: 0} tickets")
        println("6 Matches (${Prize.FIRST.prizeMoney} KRW) – ${results[Prize.FIRST] ?: 0} tickets")

        val totalWinnings = results.entries.sumOf { (prize, count) -> prize.prizeMoney * count }
        val profitRate = (totalWinnings.toDouble() / purchaseAmount) * 100
        println("Total return rate is ${String.format("%.1f", profitRate)}%.")
    }
}