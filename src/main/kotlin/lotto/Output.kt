package lotto

import lotto.LottoPrize.*
import lotto.NumberUtil.formatDouble

class Output {

    fun printIssuedTickets(count: Int, issuedTickets: List<List<Int>>) {
        println("You have purchased $count tickets.")
        issuedTickets.forEach {
            println(it)
        }
        println()
    }

    fun printWinningStatistics(profitRate: Double) {
        println("Winning Statistics")
        println("---")
        println(THREE_MATCHES.toString())
        println(FOUR_MATCHES.toString())
        println(FIVE_MATCHES.toString())
        println(FIVE_MATCHES_BONUS.toString())
        println(SIX_MATCHES.toString())
        println("Total return rate is ${profitRate.formatDouble()}%.")
    }
}
