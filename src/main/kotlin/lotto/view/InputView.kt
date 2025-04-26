package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.validation.PurchaseAmountValidator

object InputView {
    fun readPurchaseAmount(): Int {
        while (true) {
            println("Please enter the purchase amount.")
            val purchaseAmount = Console.readLine()

            try {
                PurchaseAmountValidator.validate(purchaseAmount)
                return purchaseAmount.toInt()
            } catch (error: IllegalArgumentException) {
                println(error.message)
            }
        }
    }

    fun readWinningNumbers(): String {
        println()
        println("Please enter last week's winning numbers.")
        val winningNumbers = Console.readLine()

        return winningNumbers
    }

    fun readBonusNumber(): String {
        println()
        println("Please enter the bonus number.")
        val bonusNumber = Console.readLine()

        return bonusNumber
    }
}

