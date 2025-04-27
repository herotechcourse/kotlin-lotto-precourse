package lotto.view

import lotto.domain.Rank
import lotto.domain.LottoTicket

object OutputView {
  fun printTickets(tickets: List<LottoTicket>) {
    println("You have purchased ${tickets.size} tickets.")
    tickets.forEach { println(it.numbers())}
  }
  
   fun printResult(ranks: List<Rank>, purchaseAmount: Int) {
        println("Winning Statistics")
        println("---")
        val result = ranks.groupingBy { it }.eachCount()
        Rank.values().filter { it != Rank.NONE }.forEach {
            println("${it.matchCount} Matches${if (it.bonus) " + Bonus Ball" else ""} (${it.reward} KRW) - ${result[it] ?: 0} ticket(s)")
        }
        println("Total return rate is ${calculateProfit(ranks, purchaseAmount)}%.")
    }

    private fun calculateProfit(ranks: List<Rank>, purchaseAmount: Int): Double {
        val totalReward = ranks.sumOf { it.reward }
        return String.format("%.1f", totalReward * 100.0 / purchaseAmount).toDouble()
    }
}