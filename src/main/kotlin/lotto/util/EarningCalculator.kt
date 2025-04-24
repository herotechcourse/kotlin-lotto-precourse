package lotto.util

object EarningCalculator {

    fun calculateEarningsRate(winningAmount: Int, purchaseAmount: Int): String {
        val earningsRate = winningAmount.toDouble() * 100 / purchaseAmount
        val roundedEarningsRate = Math.round(earningsRate * 10) / 10.0
        return "%,.1f".format(roundedEarningsRate)
    }
}