package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoMachine {
  fun generateTickets(count: Int): List<Lotto> = List(count) {
    Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted())
  }

  fun evaluateTickets(tickets: List<Lotto>, winningNumbers: List<Int>, bonus: Int): Map<PrizeRank, Int> {
    return tickets
      .map { it.matchRank(winningNumbers, bonus) }
      .groupingBy { it }
      .eachCount()
      .filterKeys { it != PrizeRank.NONE }
  }

  fun calculateProfit(statistics: Map<PrizeRank, Int>, purchaseAmount: Int): Double {
    val totalPrize = statistics.entries.sumOf { (rank, count) -> rank.prize * count }
    return if (purchaseAmount == 0) 0.0 else totalPrize * 100.0 / purchaseAmount
  }
}