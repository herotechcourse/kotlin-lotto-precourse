package lotto.domain

import lotto.constant.Constants

object ProfitCalculator {

    fun calculate(totalPrize: Int, purchaseAmount: Int): Double {
        require(purchaseAmount > 0) { Constants.ERROR_INVALID_TOTAL_AMOUNT }
        val profitRate = (totalPrize.toDouble() / purchaseAmount) * 100
        return String.format("%.1f", profitRate).toDouble()
    }
}