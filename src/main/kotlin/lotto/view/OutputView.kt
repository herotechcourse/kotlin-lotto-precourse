package lotto.view

import lotto.Lotto
import lotto.Rank

class OutputView {
  fun printTickets(tickets: List<Lotto>) {
    println()
    println("You have purchased ${tickets.size} tickets.")
    tickets.forEach { println(it.getSortedNumbers()) }
  }
  fun printResults(winners: Map<Rank, Int>) {
    println()
    println("Winning Statistics")
    println("---")
    for (rank in Rank.values()) {
      if (rank == Rank.FIVE_MATCHES_WITH_BONUS) {
        println(
                "${rank.matchingCount} Matches + Bonus Ball (${Rank.formattedPrize(rank.prize)} KRW) – ${winners[rank] ?: 0} tickets"
        )
        continue
      }
      println(
              "${rank.matchingCount} Matches (${Rank.formattedPrize(rank.prize)} KRW) – ${winners[rank] ?: 0} tickets"
      )
    }
  }
  fun printProfitRate(rate: Double) {
    val formattedRate = "%.1f".format(rate).replace(',', '.')
    println("Total return rate is ${formattedRate}%.")
  }
}


