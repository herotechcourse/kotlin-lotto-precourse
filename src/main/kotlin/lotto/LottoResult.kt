package lotto

class LottoResult(
  private val tickets: List<Lotto>,
  private val winning: List<Int>,
  private val bonus: Int
) {
  private val rankCounts = mutableMapOf<Rank, Int>()

  init {
    Rank.entries.forEach { rankCounts[it] = 0 }
    evaluate()
  }

  private fun evaluate() {
    for (ticket in tickets) {
      val matchCount = ticket.getNumbers().count { it in winning }
      val bonusMatch = bonus in ticket.getNumbers()
      val rank = Rank.of(matchCount, bonusMatch)
      rank?.let { rankCounts[it] = rankCounts.getValue(it) + 1 }
    }
  }

  fun getRankCounts(): Map<Rank, Int> = rankCounts.toMap()

  fun totalWinnings(): Int {
    return rankCounts.entries.sumOf { (rank, count) -> rank.prize * count }
  }
}
