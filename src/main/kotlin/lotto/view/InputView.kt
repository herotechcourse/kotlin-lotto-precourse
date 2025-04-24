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
        println("\nPlease enter last week's winning numbers.")
        val winningNumbers = Console.readLine()

        return winningNumbers
    }
}

