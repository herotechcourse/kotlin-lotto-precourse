package lotto.presentation.view


import lotto.Lotto
import lotto.domain.model.Rank
import java.text.NumberFormat
import java.util.*

object OutputView {

  fun printPurchasedTickets(tickets: List<Lotto>) {
    println("You have purchased ${tickets.size} tickets.")
    tickets.forEach { ticket ->
      println(ticket.getNumbers())
    }
  }

  fun printWinningStatisticsHeader() {
    println()
    println("Winning Statistics")
    println("---")
  }

  fun printStatistics(rankResults: List<Rank>) {
    val formatter = NumberFormat.getNumberInstance(Locale.US)

    Rank.entries
      .filter { it != Rank.NONE }
      .sortedBy { it.prize }
      .forEach { rank ->
        val matchCount = when (rank) {
          Rank.FIFTH -> 3
          Rank.FOURTH -> 4
          Rank.THIRD -> 5
          Rank.SECOND -> 5
          Rank.FIRST -> 6
          else -> 0
        }
        val count = rankResults.count { it == rank }
        val bonusText = if (rank == Rank.SECOND) " + Bonus Ball" else ""
        println("${matchCount} Matches$bonusText (${formatter.format(rank.prize)} KRW) – $count tickets")
      }
  }

  fun printProfitRate(profitRate: Double) {
    println(String.format("Total return rate is %.1f%%.", profitRate))  }

}
