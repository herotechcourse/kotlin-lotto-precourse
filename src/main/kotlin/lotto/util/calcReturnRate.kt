package lotto.util

fun calcReturnRate (totalPrize: Int, purchaseAmount: Int): Double{
        return ((totalPrize.toDouble() / purchaseAmount) * 100)
}