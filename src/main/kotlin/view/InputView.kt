package view

import camp.nextstep.edu.missionutils.Console
import view.ParseAndValidate.purchaseAmount
import view.ParseAndValidate.winningNumbers
import view.ParseAndValidate.bonusNumber

object InputView {
    fun readPurchaseAmount(): Int =
        retry("Please enter the purchase amount.") {
            purchaseAmount(Console.readLine())
        }

    fun readWinningNumbers(): List<Int> =
        retry("Please enter last week's winning numbers.") {
            winningNumbers(Console.readLine())
        }

    fun readBonusNumber(numbers: List<Int>): Int =
        retry("Please enter the bonus number.") {
            bonusNumber(Console.readLine(), numbers)
        }

    private inline fun <T> retry(prompt: String, block: () -> T): T {
        while (true) {
            try {
                println(prompt)
                return block()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}