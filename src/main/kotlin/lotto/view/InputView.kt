package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.InputValidator
import lotto.Lotto
import lotto.WinningNumbers

class InputView {

    // Read money amount and return the number of tickets
    fun readPurchase(): Int {

        while (true) {
            try {
                println("Please enter the purchase amount.")
                val amount = Console.readLine()
                val amountMoney = InputValidator.validateMoneyAmount(amount)

                return (amountMoney/Lotto.PRICE_TICKET).toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    // Read winning numbers that include main numbers and bonus number
    fun readWinningNumbers(): WinningNumbers {

        val mainNumbers = readMainNumbers()
        val bonusNumber = readBonusNumber(mainNumbers)

        return WinningNumbers(mainNumbers, bonusNumber)
    }

    // Read main numbers
    private fun readMainNumbers(): List<Int?> {

        while (true){
            try {
                println("Please enter last week's winning numbers.")
                val main = Console.readLine()
                val mainNumbers = InputValidator.validateMainNumbers(main)

                return mainNumbers
            } catch (e: IllegalArgumentException){
                println(e.message)
            }
        }
    }

    // Read bonus number
    private fun readBonusNumber(mainNumbers: List<Int?>): Int? {
        while (true) {
            try {
                println("Please enter the bonus number.")
                val bonus = Console.readLine()
                val bonusNumber = InputValidator.validateBonusNumber(bonus, mainNumbers)

                return bonusNumber
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

}