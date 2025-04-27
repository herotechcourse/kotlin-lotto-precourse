package lotto

object OutputView {
    fun requestPurchaseAmount() = println("Please enter the purchase amount.")
    fun requestWinningNumbers() = println("Please enter last week's winning numbers.")
    fun requestBonusNumber() = println("Please enter the bonus number.")
    fun printTickets(tickets: List<List<Int>>) {
        println("\nYou have purchased ${tickets.size} tickets.")
        for (ticket in tickets) {
            println("[${ticket.sorted().joinToString(", ")}]\n")
        }
    }

    fun printResults(results: Map<Rank, Int>) {
        println("\nWinning Statistics\n---")
        for (entry in results) {
            println(
                "${entry.key.matches} (${String.format("%,d", entry.key.winning)} KRW) " + "– ${entry.value} tickets"
            )
        }
    }

    fun printStatistics(result: Double) = println("Total return rate is ${String.format("%.1f", result)}%.")
}
