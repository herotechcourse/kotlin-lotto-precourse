package lotto.model

object ReturnRateCalculator {
    fun run(purchaseAmount: Int, winningAmount: Int): Number {
        val returnRate = (winningAmount.toDouble() / purchaseAmount) * 100

        return String.format("%.1f", returnRate).toDouble()
    }
}
