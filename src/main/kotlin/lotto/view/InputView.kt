package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.validation.PurchaseAmountValidator

object InputView {
    private const val PURCHASE_AMOUNT_INPUT = "Please enter the purchase amount."
    private const val WINNING_NUMBERS_INPUT = "Please enter last week's winning numbers."
    private const val BONUS_NUMBER_INPUT = "Please enter the bonus number."

    // TO-DO: Refactor extract to fun
    fun readPurchaseAmount(): Int {
        while (true) {
            println(PURCHASE_AMOUNT_INPUT)
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
        println(WINNING_NUMBERS_INPUT)
        val winningNumbers = Console.readLine()

        return winningNumbers
    }

    fun readBonusNumber(): String {
        println()
        println(BONUS_NUMBER_INPUT)
        val bonusNumber = Console.readLine()

        return bonusNumber
    }
}
