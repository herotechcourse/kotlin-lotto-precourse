package lotto.view

//import Rank

object OutputView {

    fun promptUser(Message: String) {
        println(Message)
    }

    /*TODO: initially seeing this as a list of tickets (the random generated ones) [ticket0, .., ticketN]*/
    fun printGeneratedTickets(purchasedTickets: List<List<Int>>, totalTickets: Int) {
        println("You have purchased $totalTickets tickets.")
        for (ticket in purchasedTickets) {
            println(ticket)
        }
    }

    /*
      might cwertanly need to be changed but keeping it here for now
      fun printResult(
          rankList: List<Rank>,
          returnRate: Double
      ) {
        println("Winning Statistics")
        println("---")
        // should loop through rank list
        println(
            "{$rankList.type.name} Matches ({$rankList.type.prizeMoney} KRW) - {$rankList.count} ticket(if (count != 1) `s` else ``)")
        println("Total return rate is {$returnRate}")
      }
     */
}
