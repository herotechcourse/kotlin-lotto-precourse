package lotto.view

import lotto.model.Prize
import lotto.model.LottoResult
import lotto.Lotto

class OutputView {
  fun printPurchasedTickets(tickets: List<Lotto>) {
    println("\nYou have purchased ${tickets.size} tickets.")
    tickets.forEach { ticket ->
      println(ticket.getNumbers().joinToString(", ", "[", "]"))
    }
    println()
  }

  fun printLottoResult(result: LottoResult) {
    println("Winning Statistics\n---")

    printPrize(Prize.FIFTH, result.getResult()[Prize.FIFTH] ?: 0)
    printPrize(Prize.FOURTH, result.getResult()[Prize.FOURTH] ?: 0)
    printPrize(Prize.THIRD, result.getResult()[Prize.THIRD] ?: 0)
    printPrize(Prize.SECOND, result.getResult()[Prize.SECOND] ?: 0)
    printPrize(Prize.FIRST, result.getResult()[Prize.FIRST] ?: 0)

    val profitRate = (result.getProfitRate() * 10).toLong().toDouble() / 10
    println("Total return rate is ${profitRate}%.")
  }

  fun printPrize(rank: Prize, count: Int) {
    val matchText = when (rank) {
      Prize.FIRST -> "6 Matches"
      Prize.SECOND -> "5 Matches + Bonus Ball"
      Prize.THIRD -> "5 Matches"
      Prize.FOURTH -> "4 Matches"
      Prize.FIFTH -> "3 Matches"
      else -> return
    }

    val formattedPrize = rank.prize.toString().reversed().chunked(3).joinToString(",").reversed()
    println("$matchText ($formattedPrize KRW) - $count tickets")
  }
}