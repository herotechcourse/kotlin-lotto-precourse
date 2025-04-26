package lotto

object OutputView {
    fun displayTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it.toString()) }
    }

    fun displayResults(result: LottoMachine.LottoResult) {
        println("Winning Statistics:")
        val order = listOf(
            "3 Matches (5,000 KRW)",
            "4 Matches (50,000 KRW)",
            "5 Matches (1,500,000 KRW)",
            "5 Matches + Bonus Ball (30,000,000 KRW)",
            "6 Matches (2,000,000,000 KRW)"
        )
        for (key in order) {
            println("$key – ${result.counts[key]} tickets")
        }
        println("Total return rate is ${result.profitRate}%.")
    }
}
