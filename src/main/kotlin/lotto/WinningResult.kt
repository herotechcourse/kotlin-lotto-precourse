package lotto

import lotto.Rank

data class WinningResult(
  val rankCounts: Map<Rank, Int>,
  val totalPrize: Long
) {
  companion object {
    fun calculate(
      tickets: List<Lotto>,
      winningNumbers: Set<Int>,
      bonusNumber: Int
    ): WinningResult {
      val counts = mutableMapOf<Rank, Int>()
      var total = 0L
      tickets.forEach { lotto ->
        val matches = lotto.countMatch(winningNumbers)
        val isBonus = lotto.containsBonus(bonusNumber)
        val rank = Rank.of(matches, isBonus) ?: return@forEach
        counts[rank] = counts.getOrDefault(rank, 0) + 1
        total += rank.prize
      }
      return WinningResult(counts, total)
    }
  }
}
