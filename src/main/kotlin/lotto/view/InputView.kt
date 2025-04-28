package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseAmount(): String {
        println(MESSAGE_READ_PURCHASE_AMOUNT)
        return Console.readLine()
    }

    fun readWinningNumbers(): String {
        println(MESSAGE_READ_WINNING_NUMBERS)
        return Console.readLine()
    }

    fun readBonusNumber(): String {
        println(MESSAGE_READ_BONUS_NUMBER)
        return Console.readLine()
    }

    companion object {
        private const val MESSAGE_READ_PURCHASE_AMOUNT = "Please enter the purchase amount."
        private const val MESSAGE_READ_WINNING_NUMBERS = "Please enter last week's winning numbers."
        private const val MESSAGE_READ_BONUS_NUMBER = "Please enter the bonus number."
    }
}
