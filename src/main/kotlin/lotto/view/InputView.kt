package lotto.view

import lotto.utils.readLineFromConsole

fun inputView() {
    readPurchaseAmount()
    readWinningNumbers()
    readBonusNumber()
}

private fun readPurchaseAmount(): String {
    return readLineFromConsole("Please enter the purchase amount.")
}

private fun readWinningNumbers(): String {
    return readLineFromConsole("Please enter last week's winning numbers.")
}

private fun readBonusNumber(): String {
    return readLineFromConsole("Please enter the bonus number.")
}