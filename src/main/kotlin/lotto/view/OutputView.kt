package lotto.view

import lotto.domain.*

object OutputView {
  fun printTickets(tickets: List<Lotto>) {
    println("You have purchased ${tickets.size} tickets.")
    tickets.forEach { println(it.getNumbers()) }
  }

  fun printStatistics(result: Map<Rank, Int>, amount: Int) {
    println("\nWinning Statistics\n---")
    Rank.values().sortedByDescending { it.prize }.forEach {
      println("${it.message} - ${result.getOrDefault(it, 0)} ticket")
    }
    val totalReturn = result.entries.sumOf { it.key.prize * it.value }
    val rate = totalReturn * 100.0 / amount
    println("Total return rate is %.1f%%.".format(rate))
  }
}