package lotto.view

import lotto.domain.LottoRank

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

    fun printStats(lottoRankResults: Map<LottoRank, Pair<Int, Int>>, returnRate: Double) {
        println("Winning Statistics")
        println("---")
        for ((rank, pair) in lottoRankResults) {
            val (ticketCount, prizeMoney) = pair
            println("${rank.displayName()} (${formatNumber(prizeMoney)} KRW) – $ticketCount tickets")

        }
        println("Total return rate is ${formatNumber(returnRate)}.")

    }

    private fun formatNumber(number: Any): String {
        return when (number) {
            is Int -> number.toString()
                .reversed()
                .chunked(3)
                .joinToString(",")
                .reversed()

            is Double -> {
                val rounded = (number * 10).toInt() / 10.0
                "$rounded%"
            }

            else -> throw IllegalArgumentException("Unsupported number type")
        }
    }
}
