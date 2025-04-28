package lotto.util

fun calculateAndFormatReturnRate(totalPrize: Int, purchaseAmount: Int): String {
    val returnRate = calcReturnRate(totalPrize, purchaseAmount)
    return roundRateToString(returnRate)
}
