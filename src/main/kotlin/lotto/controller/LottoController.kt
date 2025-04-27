package lotto.controller

import lotto.util.inputPurchasedAmount

fun startLottoDraw() {
    val purchasedAmount = getPurchasedAmount()
}

fun getPurchasedAmount(): Int {
    val purchasedAmount = inputPurchasedAmount()
    return purchasedAmount
}