package lotto.archive

fun calcProfitRate(totalWinningAmount: Int, totalLottoPurchaseAmount: Int): Double {
    return totalWinningAmount.toDouble() / totalLottoPurchaseAmount.toDouble() * 100
}