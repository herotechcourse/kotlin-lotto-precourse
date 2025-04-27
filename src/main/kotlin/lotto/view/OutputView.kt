package lotto.view

import lotto.domain.PlayerData

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

    fun printStats(playerData: PlayerData) {
        println("Winning Statistics")
        println("---")
        for ((rank, pair) in playerData.rankResults) {
            val (ticketCount, prizeMoney) = pair
            println(
                "${rank.displayName()} Matches ($prizeMoney KRW) - $ticketCount ticket ${if (ticketCount != 1) "s" else ""})"
            )
            println("Total return rate is {returnRate}")
        }
    }
}
