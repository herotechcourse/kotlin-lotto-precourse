package lotto
import kotlin.math.roundToInt
class LottoResult(val winners: Map<Rank, Int>, val profitRate: Double) {}

class LottoResultCalculator {
  fun calculate(tickets: List<Lotto>, winningNumbers: List<Int>, bonus: Int): LottoResult {
    val resultCounts = mutableMapOf<Rank, Int>()
    var totalPrize = 0
    for (ticket in tickets) {
      val matchCount = ticket.countMatchingNumbers(winningNumbers)
      val bonusMatched = ticket.hasBonusNumber(bonus)
      val result = Rank.findByMatchAndBonus(matchCount, bonusMatched)
      if (result != null) {
        resultCounts[result] = resultCounts.getOrDefault(result, 0) + 1
        totalPrize += result.prize
      }
    }
    
    val investment = tickets.size * TICKET_PRICE
    val profitRate = (totalPrize.toDouble() / investment) * 100

    return LottoResult(resultCounts, profitRate)
  }

  private fun roundToNearestTenth(profitRate: Double): Double {
    return (profitRate * 10).roundToInt() / 10.0
  }
}
