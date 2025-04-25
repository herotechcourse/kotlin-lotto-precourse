package lotto

/**
 * Handles all output display logic for the Lotto application.
 * Responsible for printing tickets, result statistics, and profit rate to the console.
 */
class OutputView {

    /**
     * Prints the list of purchased lotto tickets to the console.
     *
     * @param tickets the list of Lotto objects purchased
     */
    fun printTickets(tickets: List<Lotto>) {
        println("\nYou have purchased ${tickets.size} tickets.")
        tickets.forEach { number ->
            number.displayTicket()
        }
        println("\n")
    }

    /**
     * Prints the formatted profit return rate to the console.
     *
     * @param profit the calculated profit rate as a percentage
     */
    fun printProfitReturn(profit: Double) {
        val formattedRate = String.format("%.1f%%", profit)
        println("Total return rate is $formattedRate.")
    }

    /**
     * Prints the overall rank distribution statistics to the console.
     *
     * @param statistics a map of Rank to the count of tickets achieving that rank
     */
    fun printResults(statistics: Map<Rank, Int>) {
        println("\nWinning Statistics")
        println("---")
        printRanks(statistics)
    }

    /**
     * Iterates through the Rank enum (excluding NONE) and prints how many tickets achieved each rank.
     * Formats the prize with commas and includes bonus ball indication if applicable.
     *
     * @param statistics a map of Rank to the number of tickets for each
     */
    private fun printRanks(statistics: Map<Rank, Int>) {
        Rank.entries
            .filter { it != Rank.NONE }
            .reversed()
            .forEach { rank ->
                val count = statistics.getOrDefault(rank, 0)
                val bonusText = if (rank.matchBonus) " + Bonus Ball" else ""
                val formattedPrize = String.format("%,d", rank.prize)
                println("${rank.matchCount} Matches$bonusText (${formattedPrize} KRW) – $count tickets")
            }
    }
}
