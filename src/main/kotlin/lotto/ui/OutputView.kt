package lotto.ui

import lotto.Lotto

class OutputView {

    companion object {
        fun displayPurchasedLotteryTickets(lotteryTickets: List<Lotto>) {
            println("You have purchased ${lotteryTickets.size} tickets.")
            lotteryTickets.forEach {
                println(it)
            }
            println()
        }
    }
}