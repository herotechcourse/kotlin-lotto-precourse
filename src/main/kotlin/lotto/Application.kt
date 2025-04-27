package lotto

import lotto.view.InputView
import lotto.domain.LottoGenerator

fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()
    validatePurchaseAmount(purchaseAmount)

    val ticketCount = purchaseAmount / 1000
    val lottos = LottoGenerator.generateLottos(ticketCount)

    println("You have purchased ${lottos.size} tickets.")
    lottos.forEach { println(it.getNumbers()) }
}

fun validatePurchaseAmount(amount: Int) {
    if (amount <= 0) {
        throw IllegalArgumentException("[ERROR] Purchase amount must be greater than 0.")
    }
    if (amount % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] Purchase amount must be divisible by 1,000.")
    }
}
