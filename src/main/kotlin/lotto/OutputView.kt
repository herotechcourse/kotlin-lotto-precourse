package lotto

class OutputView {

    fun displayTicketNumber(ticketNum: Int) {
        println("\nYou have purchased $ticketNum tickets.")
    }

    fun displayTickets(tickets: List<List<Int>>) {
        for (ticket in tickets) {
            println(ticket)
        }
    }

    fun displayWinningResults(matchResults: Map<Lotto.PrizeTier, Int>, returnRate: Double) {
        println("\nWinning Statistics")
        println("---")

        Lotto.PrizeTier.values().forEach { tier ->
            val count = matchResults.getOrDefault(tier, 0)
            println(tier.getDisplayText(count))
        }

        displayReturnRate(returnRate)
    }

    private fun displayReturnRate(returnRate: Double) {
        println("Total return rate is ${"%.1f".format(returnRate)}%.")
    }
}