package lotto.view

//import Rank

object OutputView {

    fun requestUser(message: String) {
        println(message)
    }

    fun showPurchase(ticketsPurchased: List<List<Int>>) {
        println("You have purchased ${ticketsPurchased.size} tickets.")
        for (ticket in ticketsPurchased) {
            println(ticket)
        }
    }

    fun printStats(
        /*  params*/
    ) {
        println("Winning Statistics")
        println("---")
        // could loop through rank list? check with player data later
        println(
            "{rankList.type} Matches ({rankList.prizeMoney} KRW) - {rankList.count} ticket(if (count != 1) `s` else ``)"
        )
        println("Total return rate is {returnRate}")
    }
}
