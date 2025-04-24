package lotto.view

import Rank

object OutputView {

  fun requestPurchase() {
    println("Please enter the purchase amount.")
  }

  /*
  TODO: initially seeing this as a list of tickets (the random generated ones) [ticket0, ..,
  ticketN]
  */
  fun printGeneratedTickets(purchasedTickets: List<List<Int>>, totalTickets: Int) {
    println("You have purchased $totalTickets tickets.")
    purchasedTickets.forEach {
      println(it.sorted().joinToString(prefix = "[", postfix = "]", separator = ", "))
    }
  }

  fun requestWinningSet() {
    println("Please enter last week's winning numbers.")
  }

  fun requestBonusNumber() {
    println("Please enter the bonus number.")
  }

  fun printResult(
      rankList: List<Rank>,
      returnRate: Double
  ) { // TODO: figure out if list can be applied if enum is involved
    println("Winning Statistics")
    println("---")
    // should loop through rank list
    println(
        "{$rankList.type.name} Matches ({$rankList.type.prizeMoney} KRW) - {$rankList.count} ticket(if (count != 1) `s` else ``)")
    println("Total return rate is {$returnRate}")
  }
}
