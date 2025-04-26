package lotto

class OutputView {
    fun displayTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")

        tickets.forEach { println(it.getNumbers()) }
    }

    fun displayStatistics(prizeCategories: Map<Prize, Int>) {
        println("Lotto result statistics:\n")

        Prize.entries.forEach { prize ->
            if (prize != Prize.NONE) {
                val count = prizeCategories.getOrDefault(prize, 0)
                val ticketLabel = listOf("ticket", "tickets")[(count > 1).compareTo(false)]
                println("${prize.description} - $count $ticketLabel")
            }
        }
    }

    fun displayProfitRate(profitRate: Double) {
        println("Total return rate is %.1f%%".format(profitRate))
    }
}