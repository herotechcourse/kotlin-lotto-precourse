package lotto

class OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it.getNumbers()) }
    }

    fun printResults(resultStatistics: Map<String, Int>, profitRate: Double) {
        println("Lotto result statistics:")
        resultStatistics.forEach { (prize, count) ->
            println("$prize – $count tickets")
        }
        println("Total return rate is %.1f%%.".format(profitRate))
    }
}
