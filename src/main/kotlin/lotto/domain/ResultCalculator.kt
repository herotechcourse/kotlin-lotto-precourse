package lotto.domain

object ResultCalculator {
  fun calculate(tickets: List<Lotto>, winning: WinningLotto): Map<Rank, Int> {
    return tickets
      .map { winning.evaluate(it) }
      .groupingBy { it }
      .eachCount()
  }
}