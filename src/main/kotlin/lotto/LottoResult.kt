package lotto

import kotlin.math.roundToInt

class LottoResult(val winners: Map<Rank, Int>, val profitRate: Double) {}

class LottoResultCalculator {
  fun calculate(tickets: List<Lotto>, winningNumbers: List<Int>, bonus: Int): LottoResult {
    val resultCounts = calculateResultCounts(tickets, winningNumbers, bonus)
    val totalPrize = calculateTotalPrize(resultCounts)
    val profitRate = calculateProfitRate(totalPrize, tickets.size)
    return LottoResult(resultCounts, profitRate)
  }

  private fun calculateResultCounts(tickets: List<Lotto>, winningNumbers: List<Int>, bonus: Int ): Map<Rank, Int> {
    val resultCounts = mutableMapOf<Rank, Int>()

    for (ticket in tickets) {
      val matchCount = ticket.countMatchingNumbers(winningNumbers)
      val bonusMatched = ticket.hasBonusNumber(bonus)
      val rank = Rank.findByMatchAndBonus(matchCount, bonusMatched)
      if (rank != null) {
        resultCounts[rank] = resultCounts.getOrDefault(rank, 0) + 1
      }
    }
    return resultCounts
  }

  private fun calculateTotalPrize(resultCounts: Map<Rank, Int>): Int {
    var totalPrize = 0
    for ((rank, count) in resultCounts) {
      totalPrize += rank.prize * count
    }
    return totalPrize
  }

  private fun calculateProfitRate(totalPrize: Int, ticketCount: Int): Double {
    return (totalPrize.toDouble() / (ticketCount * TICKET_PRICE)) * 100
  }

  private fun roundToNearestTenth(profitRate: Double): Double {
    return (profitRate * 10).roundToInt() / 10.0
  }
}
