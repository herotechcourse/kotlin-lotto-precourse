package lotto.domain.usecases

import lotto.domain.model.Rank

class ComputeProfitUseCase {
  fun run(ranks: List<Rank>, totalSpent: Int): Double {
    val totalPrize = ranks.sumOf { it.prize }
    return (totalPrize.toDouble() / totalSpent) * 100
  }
}
