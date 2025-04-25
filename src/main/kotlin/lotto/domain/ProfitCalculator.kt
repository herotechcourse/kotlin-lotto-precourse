package lotto.domain

object ProfitCalculator {

    fun calculate(totalPrize: Int, purchaseAmount: Int): Double {
        require(purchaseAmount > 0) { "[ERROR] Purchase amount must be greater than 0." }

        val profitRate = (totalPrize.toDouble() / purchaseAmount) * 100
        return String.format("%.1f", profitRate).toDouble()
    }
}