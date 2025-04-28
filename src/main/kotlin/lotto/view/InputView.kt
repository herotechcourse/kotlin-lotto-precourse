package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.validator.validatePurchaseAmount
import lotto.validator.validateWinningNumbers
import lotto.validator.validateBonusNumber

object InputView {

    fun readPurchaseAmount(): Int {
        while (true) { println("Please enter the purchase amount.")
            val line = Console.readLine().trim()
            try {
                return validatePurchaseAmount(line)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readWinningNumbers(): Set<Int> {
        while (true) { println("Please enter last week's winning numbers.")
            val line = Console.readLine().trim()
            try {
                return validateWinningNumbers(line).toSet()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readBonusNumber(winningNumbers: Set<Int>): Int {
        while (true) { println("Please enter the bonus number.")
            val line = Console.readLine().trim()
            try {
                return validateBonusNumber(line, winningNumbers.toList())
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}
