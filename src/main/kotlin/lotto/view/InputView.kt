package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.InputValidator

object InputView {

    fun readPurchaseAmount(): Int {
        while (true) {
            println("Please enter the purchase amount.")
            val input = Console.readLine()
            try {
                return InputValidator.validateAmount(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readWinningNumbers(): List<Int> {
        while (true) {
            println("Please enter last week's winning numbers.")
            val input = Console.readLine()
            try {
                return InputValidator.validateWinningNumbers(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            println("Please enter the bonus number.")
            val input = Console.readLine()
            try {
                return InputValidator.validateBonusNumber(input, winningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}