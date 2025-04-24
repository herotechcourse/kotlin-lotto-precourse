package lotto

class OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("\nYou have purchased ${tickets.size} tickets.")
        tickets.forEach { number ->
            number.displayTicket()
        }
        println("\n")
    }

    fun printProfitReturn(profit: Double) {
        val formattedRate = String.format("%.1f%%", profit)
        println("Profit rate: $formattedRate")
    }

    fun printResults(statistics: Map<Rank, Int>) {
        println("\nWinning Statistics")
        println("------------------")
        Rank.entries
            .filter { it != Rank.NONE }
            .forEach { rank ->
                val count = statistics.getOrDefault(rank, 0)
                val bonusText = if (rank.matchBonus) " + bonus" else ""
                println("${rank.matchCount} numbers$bonusText (${rank.prize} KRW) - $count ticket(s)")
            }
    }

}