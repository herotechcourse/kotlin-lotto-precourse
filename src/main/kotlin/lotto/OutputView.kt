package lotto

object OutputView {
  fun printPurchasedTickets(tickets: List<Lotto>) {
    println("You have purchased ${tickets.size} tickets.")
    tickets.forEach { println(it.numbers.sorted()) }
  }

  fun printStatistics(statistics: Map<PrizeRank, Int>) {
    println("Winning Statistics\n---")
    println("3 Matches (5,000 KRW) – ${statistics[PrizeRank.FIFTH] ?: 0} tickets")
    println("4 Matches (50,000 KRW) – ${statistics[PrizeRank.FOURTH] ?: 0} tickets")
    println("5 Matches (1,500,000 KRW) – ${statistics[PrizeRank.THIRD] ?: 0} tickets")
    println("5 Matches + Bonus Ball (30,000,000 KRW) – ${statistics[PrizeRank.SECOND] ?: 0} tickets")
    println("6 Matches (2,000,000,000 KRW) – ${statistics[PrizeRank.FIRST] ?: 0} tickets")
  }

  fun printProfitRate(rate: Double) {
    println("Total return rate is ${"%.1f".format(rate)}%.")
  }

  fun printError(message: String) {
    println("[ERROR] $message")
  }
}