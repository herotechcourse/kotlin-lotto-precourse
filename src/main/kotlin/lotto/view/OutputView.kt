package lotto.view

import lotto.domain.Rank
import lotto.domain.LottoTicket

object OutputView {
  fun printTickets(tickets: List<LottoTicket>) {
    println("You have purchased ${tickets.size} tickets.")
    tickets.forEach { println(it.numbers())}
  }

  private fun formatReward(reward: Int): String {
    return "%,d".format(reward)
  }
  
  fun printResult(ranks: List<Rank>, purchaseAmount: Int) {
      println("Winning Statistics")
      println("---")
      for (rank in Rank.values()) {
          if (rank != Rank.NONE) {
              val count = ranks.count { it == rank }
              println("${rank.description()} (${formatReward(rank.reward)} KRW) – $count tickets")
          }
      }
      println("Total return rate is ${calculateProfit(ranks, purchaseAmount)}%.")
  }

    private fun calculateProfit(ranks: List<Rank>, purchaseAmount: Int): Double {
        val totalReward = ranks.sumOf { it.reward }
        return String.format("%.1f", totalReward * 100.0 / purchaseAmount).toDouble()
    }
}