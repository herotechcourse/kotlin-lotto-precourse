package lotto.ui

import lotto.Lotto
import lotto.business.LottoMatchType
import java.util.*

class OutputView {
    fun displayPurchasedLotteryTickets(lotteryTickets: List<Lotto>) {
        println("You have purchased ${lotteryTickets.size} tickets.")
        lotteryTickets.forEach {
            println(it)
        }
    }

    fun displayWinningStatistics(winningStatistics: Map<LottoMatchType, Int>, purchaseAmount: Long) {
        println("Winning Statistics")
        println("---")
        var totalWinnings = 0L
        winningStatistics.forEach { singleLottoMatch ->
            val earnings = singleLottoMatch.value * singleLottoMatch.key.price
            totalWinnings += earnings
            println("${singleLottoMatch.key.description} – ${singleLottoMatch.value} tickets")
        }
        val returnPercentage = totalWinnings.toDouble() / purchaseAmount * 100
        val formattedPercentage = String.format(Locale.US, "%.1f", returnPercentage)
        println("Total return rate is $formattedPercentage%.")
    }
}