package lotto

import lotto.views.InputView

fun main() {
    val inputView = InputView()
    val game = LotteryGame()

    val purchaseAmount = inputView.getPurchaseAmount()
}


