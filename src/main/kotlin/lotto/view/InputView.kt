package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.exception.ApplicationException
import lotto.util.Validator

object InputView {

    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        return readInput { Validator.validateAmount(Console.readLine()) }
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        return readInput { Validator.validateWinningNumbers(Console.readLine()) }
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        return readInput { Validator.validateBonusNumber(Console.readLine()) }
    }

    private inline fun <T> readInput(block: () -> T): T {
        while (true) {
            try {
                return block()
            } catch (e: ApplicationException) {
                println(e.message)
            } catch (e: IllegalArgumentException) {
                println("[ERROR] Invalid input. Please try again.")
            }
        }
    }
}
