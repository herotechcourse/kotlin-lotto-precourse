package lotto.view

import lotto.Lotto
import lotto.model.LottoResult
import lotto.model.PrizeRank

class OutputView {
    fun printPurchasedTickets(tickets: List<Lotto>) {
        println()
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { ticket ->
            println(formatLottoNumbers(ticket.getNumbers()))
        }
        println()
    }

    private fun formatLottoNumbers(numbers: List<Int>): String {
        return numbers.joinToString(", ", "[", "]")
    }

    fun printLottoResult(result: LottoResult) {
        println("Winning Statistics")
        println("---")

        printPrizeRank(PrizeRank.FIFTH, result.getResult()[PrizeRank.FIFTH] ?: 0)
        printPrizeRank(PrizeRank.FOURTH, result.getResult()[PrizeRank.FOURTH] ?: 0)
        printPrizeRank(PrizeRank.THIRD, result.getResult()[PrizeRank.THIRD] ?: 0)
        printPrizeRank(PrizeRank.SECOND, result.getResult()[PrizeRank.SECOND] ?: 0)
        printPrizeRank(PrizeRank.FIRST, result.getResult()[PrizeRank.FIRST] ?: 0)

        val profitRate = roundToOneDecimal(result.getProfitRate())
        println("Total return rate is ${profitRate}%.")
    }

    private fun roundToOneDecimal(value: Double): Double {
        return (value * 10).toLong().toDouble() / 10
    }

    private fun printPrizeRank(rank: PrizeRank, count: Int) {
        val matchText = when(rank) {
            PrizeRank.FIRST -> "6 Matches"
            PrizeRank.SECOND -> "5 Matches + Bonus Ball"
            PrizeRank.THIRD -> "5 Matches"
            PrizeRank.FOURTH -> "4 Matches"
            PrizeRank.FIFTH -> "3 Matches"
            else -> return
        }

        val formattedPrize = rank.prize.toString().reversed().chunked(3).joinToString(",").reversed()
        println("$matchText ($formattedPrize KRW) – $count tickets")
    }

    fun printError(message: String) {
        println(message)
    }
}