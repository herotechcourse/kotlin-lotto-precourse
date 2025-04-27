package lotto.view
import java.text.DecimalFormat
import lotto.Lotto
import lotto.LottoGrade
import lotto.LottoResult

class OutputView {
    private val decimalFormat = DecimalFormat("0.0")

    fun printPurchasedTickets(tickets: List<Lotto>) {
        println("\nYou have purchased ${tickets.size} tickets.")
        tickets.forEach { ticket ->
            println(ticket.getNumbers())
        }
    }

    fun printResult(result: LottoResult, purchaseAmount: Int) {
        println("\nWinning Statistics")
        println("---")
        printRankStatistics(result)
        printReturnRate(result, purchaseAmount)
    }

    private fun printRankStatistics(result: LottoResult) {
        printRankStatistic(LottoGrade.FIFTH, result)
        printRankStatistic(LottoGrade.FOURTH, result)
        printRankStatistic(LottoGrade.THIRD, result)
        printRankStatistic(LottoGrade.SECOND, result)
        printRankStatistic(LottoGrade.FIRST, result)
    }

    private fun printRankStatistic(rank: LottoGrade, result: LottoResult) {
        val count = result.getWinCount(rank)
        val rankDescription = when (rank) {
            LottoGrade.FIFTH -> "3 Matches (5,000 KRW)"
            LottoGrade.FOURTH -> "4 Matches (50,000 KRW)"
            LottoGrade.THIRD -> "5 Matches (1,500,000 KRW)"
            LottoGrade.SECOND -> "5 Matches + Bonus Ball (30,000,000 KRW)"
            LottoGrade.FIRST -> "6 Matches (2,000,000,000 KRW)"
            else -> return
        }
        println("$rankDescription – $count tickets")
    }

    private fun printReturnRate(result: LottoResult, purchaseAmount: Int) {
        val returnRate = result.calculateReturnRate(purchaseAmount)
        println("Total return rate is ${decimalFormat.format(returnRate)}%.")
    }
}