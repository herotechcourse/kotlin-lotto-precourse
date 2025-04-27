package lotto

object OutputView {
    fun displayLottoTickets(tickets: List<Lotto>) {
        println("\n You have purchased ${tickets.size} tickets.")
        tickets.forEach {
            println(it)
        }
    }

    fun displayLottoResults(result: Map<Rank, Int>, purchaseAmount: Int, totalWinnings: Int) {
        println("\nLotto result statistics:")
        println("3 Matches (5,000 KRW) – ${result[Rank.FIFTH] ?: 0} tickets")
        println("4 Matches (50,000 KRW) – ${result[Rank.FOURTH] ?: 0} tickets")
        println("5 Matches (1,500,000 KRW) – ${result[Rank.THIRD] ?: 0} tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – ${result[Rank.SECOND] ?: 0} tickets")
        println("6 Matches (2,000,000,000 KRW) – ${result[Rank.FIRST] ?: 0} tickets")

        if (purchaseAmount == 0) {
            println("[ERROR] Total return rate cannot be calculated (purchase amount is zero).")
            return
        }

        val profit = totalWinnings.toDouble() / purchaseAmount * 100
        println("Total return rate is %.1f%%.".format(profit))
    }
}