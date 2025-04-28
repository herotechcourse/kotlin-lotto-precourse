package lotto.view

import lotto.domain.Lotto
import lotto.domain.Prize
import lotto.domain.WinningResult
import java.text.NumberFormat
import java.util.Locale

class ResultView {
    private val prizeDescriptions = mapOf(
        Prize.FIRST to "6 Matches",
        Prize.SECOND to "5 Matches + Bonus Ball",
        Prize.THIRD to "5 Matches",
        Prize.FOURTH to "4 Matches",
        Prize.FIFTH to "3 Matches"
    )
    
    fun printPurchasedTickets(lottos: List<Lotto>) {
        println()
        println("You have purchased ${lottos.size} tickets.")
        lottos.forEach { lotto ->
            println(lotto.getNumbers())
        }
    }
    
    fun printWinningResults(result: WinningResult, purchaseAmount: Int) {
        printWinningHeader()
        printAllPrizes(result)
        printReturnRate(result, purchaseAmount)
    }
    
    private fun printWinningHeader() {
        println()
        println("Winning statistics")
        println("---")
    }
    
    private fun printAllPrizes(result: WinningResult) {
        val prizeResults = result.getWinningTicketsByPrize()
        
        // Always print in this order, regardless of whether there are winners
        printPrizeResult(Prize.FIFTH, prizeResults.getOrDefault(Prize.FIFTH, 0))
        printPrizeResult(Prize.FOURTH, prizeResults.getOrDefault(Prize.FOURTH, 0))
        printPrizeResult(Prize.THIRD, prizeResults.getOrDefault(Prize.THIRD, 0))
        printPrizeResult(Prize.SECOND, prizeResults.getOrDefault(Prize.SECOND, 0))
        printPrizeResult(Prize.FIRST, prizeResults.getOrDefault(Prize.FIRST, 0))
    }
    
    private fun printReturnRate(result: WinningResult, purchaseAmount: Int) {
        val returnRate = result.calculateReturnRate(purchaseAmount)
        println("Total return rate is ${String.format("%.1f", returnRate)}%.")
    }
    
    private fun printPrizeResult(prize: Prize, count: Int) {
        val formattedAmount = formatAmount(prize.amount)
        val matchDescription = getPrizeDescription(prize)
        println("$matchDescription (${formattedAmount}) – ${count} tickets")
    }
    
    private fun getPrizeDescription(prize: Prize): String {
        return prizeDescriptions.getOrDefault(prize, "${prize.matchCount} Matches")
    }
    
    private fun formatAmount(amount: Int): String {
        return "${NumberFormat.getNumberInstance(Locale.US).format(amount)} KRW"
    }
}