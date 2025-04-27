package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readPurchase(): Int {

        while (true) {
            try {
                println("Please enter the purchase amount.")
                val amount = Console.readLine()
                val amountMoney = InputValidator.validateMoneyAmount(amount)

                return amountMoney/1000
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun promptWinningNumbers(): WinningNumbers {

        val mainNumbers = readMainNumbers()
        val bonusNumber = readBonusNumber(mainNumbers)

        return WinningNumbers(mainNumbers, bonusNumber)
    }

    private fun readMainNumbers(): List<Int?> {
        while (true){
            try {
                println("Please enter last week's winning numbers (commas separated).")
                val main = Console.readLine()
                val mainNumbers = InputValidator.validateMainNumbers(main)

                return mainNumbers
            } catch (e: IllegalArgumentException){
                println(e.message)
            }
        }
    }

    private fun readBonusNumber(mainNumbers: List<Int?>): Int? {
        while (true) {
            try {
                println("Please enter the bonus number.")
                val bonus = Console.readLine()//.toIntOrNull()
                val bonusNumber = InputValidator.validateBonusNumber(bonus, mainNumbers)
                return bonusNumber

            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

}