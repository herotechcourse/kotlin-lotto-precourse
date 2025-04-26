package lotto

import lotto.utils.InputView.readBonusNumber
import lotto.utils.InputView.readPurchaseAmount
import lotto.utils.InputView.readWinningNumbers

fun main() {
    val purchaseAmount = readPurchaseAmount()
    val winningNumbers = readWinningNumbers() // TODO: decide whether to use instance of Lotto class
    val bonusNumber = readBonusNumber(winningNumbers)
    val numberOfTickets = (purchaseAmount / 1000u).toInt()
}
