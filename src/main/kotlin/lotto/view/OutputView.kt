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
            println("${rank.displayName()} (${formatNumber(prizeMoney)} KRW) – $ticketCount tickets")

        }
        println("Total return rate is {returnRate}")
    }

    private fun formatNumber(number: Int): String {
        return number.toString()
            .reversed()
            .chunked(3)
            .joinToString(",")
            .reversed()
    }
}
