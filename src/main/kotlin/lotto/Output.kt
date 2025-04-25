package lotto

import lotto.NumberUtil.formatDouble

class Output {

    fun printIssuedTickets(count: Int, issuedTickets: List<List<Int>>) {
        println("\nYou have purchased $count tickets.")
        issuedTickets.forEach {
            println(it)
        }
    }

    fun printWinningStatistics(statistics: LottoStatistics, purchaseAmount: Int) {
        println("\nWinning Statistics")
        println("---")
        println(statistics.toString())
        println("Total return rate is ${statistics.getProfitRate(purchaseAmount).formatDouble()}%.")
    }
}
