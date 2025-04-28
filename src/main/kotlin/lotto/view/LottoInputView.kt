package lotto.view

import camp.nextstep.edu.missionutils.Console

class LottoInputView {
    fun getLottoPurchaseMoney(): String {
        printLottoPurchaseMessage()
        return Console.readLine()
    }


    private fun printLottoPurchaseMessage() {
        println("Please enter the purchase amount.")
    }

    fun getWinningNumber(): String {
        printWinningNumberMessage()
        val winningNumber = Console.readLine()
        println()
        return winningNumber
    }


    private fun printWinningNumberMessage() {
        println("Please enter last week's winning numbers.")
    }

    fun getBonusNumber(): String {
            printBonusNumberMessage()
            val bonusNumber = Console.readLine()
            println()
            return bonusNumber
        }

    private fun printBonusNumberMessage() {
        println("Please enter the bonus number.")
    }
}
