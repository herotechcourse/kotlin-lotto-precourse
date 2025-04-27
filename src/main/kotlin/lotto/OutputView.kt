package lotto

object OutputView {
  fun printTickets(tickets: List<Lotto>) {
    println("You have purchased ${tickets.size} tickets.")
    tickets.forEach { println(it.getNumbers()) }
  }

  fun printResult(result: LottoResult, amountSpent: Int) {
    println("\nWinning Statistics")
    println("---")
    result.getRankCounts().entries.sortedByDescending { it.key.prize }.forEach { (rank, count) ->
      println("${rank.matchCount} Matches${if (rank.bonusRequired) " + Bonus Ball" else ""} (${rank.prize} KRW) – $count tickets")
    }
    val rate = result.totalWinnings().toDouble() / amountSpent * 100
    println("Total return rate is ${"%.1f".format(rate)}%.")
  }
}
