package lotto

class LottoResult(val winners: Map<Rank, Int>, val profitRate: Double) {}

class LottoResultCalculator {
  fun calculate(tickets: List<Lotto>, winningNumbers: List<Int>, bonus: Int): LottoResult {
    val resultCounts = mutableMapOf<Rank, Int>()
    for (ticket in tickets) {
      val matchCount = ticket.countMatchingNumbers(winningNumbers)
      val bonusMatched = ticket.hasBonusNumber(bonus)
      val result = Rank.findByMatchAndBonus(matchCount, bonusMatched)
      if (result != null) {
        resultCounts[result] = resultCounts.getOrDefault(result, 0) + 1
      }
    }
    
    // profit rate

    return LottoResult(resultCounts, null)
  }
}
