package lotto.domain.service

import lotto.domain.model.Money
import lotto.domain.model.Rank

class Statistics {
    fun calculateTotalReturnRate(money: Money, winResult: WinResult): Double {
        val totalPrize = calculateTotalPrize(winResult)
        val purchaseAmount = getPurchaseAmount(money)

        if (purchaseAmount == 0L) {
            return 0.0
        }

        return calculateReturnRate(totalPrize, purchaseAmount)
    }

    private fun calculateTotalPrize(winResult: WinResult): Long {
        var totalPrize = 0L
        for ((rank, count) in winResult.getResult()) {
            if (rank != Rank.NONE) {
                totalPrize += rank.prizeMoney.toLong() * count
            }
        }

        return totalPrize
    }

    private fun getPurchaseAmount(money: Money): Long {
        return money.amount.toLong()
    }

    private fun calculateReturnRate(totalPrize: Long, purchaseAmount: Long): Double {
        val rawRate = (totalPrize.toDouble() / purchaseAmount) * 100
        return String.format("%.1f", rawRate).toDouble()
    }
}