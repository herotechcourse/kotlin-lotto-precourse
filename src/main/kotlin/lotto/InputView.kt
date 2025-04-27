package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.Constants.LOTTO_NUMBER_COUNT

object InputView {

    fun readPurchaseAmount(): Int {
        while (true) {
            println("Please enter the purchase amount --->")
            val input = Console.readLine()
            try {
                val amount = input.toInt()
                require(amount % 1000 == 0) { "[ERROR] Amount must be divisible by 1000." }
                return amount
            } catch (e: NumberFormatException) {
                println("[ERROR] Amount must be a number.")
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readWinningNumbers(): List<Int> {
        while (true) {
            println("Please enter last week's $LOTTO_NUMBER_COUNT winning numbers(comma-separated) ---->")
            val input = Console.readLine()
            try {
                return InputValidator.parseAndValidateLottoNumbers(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            println("Please enter the bonus number ---> ")
            val input = Console.readLine()
            try {
                return InputValidator.parseAndValidateBonusNumber(input, winningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

}
