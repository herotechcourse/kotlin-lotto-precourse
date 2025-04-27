package lotto

class OutputView {
    companion object {
        fun displayTickets(tickets: List<Lotto>) {
            println("You have purchased ${tickets.size} tickets.")

            tickets.forEach { println(it.getNumbers()) }
        }

        fun displayStatistics(prizeCategories: Map<Prize, Int>, profitRate: Double) {
            println("Lotto result statistics:")

            Prize.entries.reversed().forEach { prize ->
                if (prize != Prize.NONE) {
                    val count = prizeCategories.getOrDefault(prize, 0)
                    println("${prize.description} – $count tickets")
                }
            }

            println("Total return rate is %.1f%%.".format(profitRate))
        }
    }
}