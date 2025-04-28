package lotto.view
import lotto.Lotto
import lotto.domain.Rank

object OutputView {
  fun printTickets(tickets : List<Lotto>){
    println("You have purchased ${tickets.size} tickets.")
    tickets.forEach{ println(it.getNumbers())}
  }

  fun printResult(stats : Map<Rank,Int>, purchase: Int){
    println("Winning Statistics")
    println("---")
    Rank.values().filter { it!=Rank.NONE }.forEach{
      rank ->
      val count = stats.getOrDefault(rank,0)
      val label =
        if(rank==Rank.SECOND) "5 Matches + Bonus Ball"
        else  "${rank.matchCount} Matches"
      println("$label (${"%,d".format(rank.prize)} KRW) - $count tickets")
    }
    var totalPrize = 0L;
    for ((rank, count) in stats) {
      totalPrize += rank.prize * count
    }
    val rate = totalPrize.toDouble()/purchase * 100
    println("Total return rate is ${"%.1f".format(rate)}%.")
  }
}