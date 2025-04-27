package lotto

class LottoResult(private val statistics: Map<PrizeRank, Int>) {
  fun getStatistics(): Map<PrizeRank, Int> = statistics

  companion object {
    fun fromTickets(tickets: List<Lotto>, winningNumbers: List<Int>, bonus: Int): LottoResult {
      val stats = tickets
        .map { it.matchRank(winningNumbers, bonus) }
        .groupingBy { it }
        .eachCount()
        .filterKeys { it != PrizeRank.NONE }
      return LottoResult(stats)
    }
  }
}