package lotto

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

class InputView {
    fun getAmount(): Int {
        while (true) {
            try {
                println("Please enter the purchase amount.")
                val amount = Console.readLine()
                println()
                requireNumberFormat(amount)
                return amount!!.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getWinningNumbers(): List<Int> {
        while (true) {
            try {
                println("Please enter last week's winning numbers")
                val winningNumbers = Console.readLine()
                println()
                requireWinningNumbersInputFormat(winningNumbers)
                return winningNumbers!!.split(",").map { it.toInt() }
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun getBonusNumber(): Int {
        while (true) {
            try {
                println("Please enter the bonus number")
                val bonus = Console.readLine()
                println()
                requireNumberFormat(bonus)
                return bonus!!.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun requireNumberFormat(input: String?) {
        require(
            !
            input.isNullOrBlank()
                    && input.matches(Regex("^[0-9]+$"))
        ) { "[ERROR] You must enter a number." }
    }

    private fun requireWinningNumbersInputFormat(winningNumbers: String?) {
        require(
            !winningNumbers.isNullOrBlank()
                    && winningNumbers.trim().matches(Regex("^([0-9]+,)*[0-9]+$"))
        ) { "[ERROR] Input must consist of comma-separated digits (e.g 1,2,3,4,5,6)" }
    }
}