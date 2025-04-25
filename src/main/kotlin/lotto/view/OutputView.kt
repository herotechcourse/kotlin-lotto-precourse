package lotto.view

//import Rank

object OutputView {

    fun requestUser(message: String) {
        println(message)
    }

    /*TODO: initially seeing this as a list of tickets (the random generated ones) [ticket0, .., ticketN]*/
    fun showPurchase(ticketsPurchase: List<List<Int>>) {
        println("You have purchased ${ticketsPurchase.size} tickets.")
        for (ticket in ticketsPurchase) {
            println(ticket)
        }
    }

    fun printStats(
        /*   rankList: List<Rank>,
           returnRate: Double*/
    ) {
        println("Winning Statistics")
        println("---")
        // could loop through rank list ?
        println(
            "{rankList.type} Matches ({rankList.prizeMoney} KRW) - {rankList.count} ticket(if (count != 1) `s` else ``)"
        )
        println("Total return rate is {returnRate}")
    }
}
