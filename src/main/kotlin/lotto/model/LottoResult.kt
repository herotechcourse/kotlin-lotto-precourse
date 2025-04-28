package lotto.model

class LottoResult(private val results: Map<Prize, Int>, private val totalTickets: Int) {
  fun getResult(): Map<Prize, Int> {
    return results
  }

  fun getTotalPrize(): Int {
    return results.entries.sumOf { (rank, count) -> rank.prize * count }
  }

  fun getProfitRate(): Double {
    val cost = totalTickets * 1000L
    return getTotalPrize().toDouble() / cost * 100
  }
}