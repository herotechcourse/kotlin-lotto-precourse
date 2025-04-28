package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.validation.LottoValidator

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        return readValidatedInput(LottoValidator::validatePurchaseAmount)
    }

    fun readWinningNumbers(): List<Int> {
        println("\nPlease enter last week's winning numbers.")
        return readValidatedInput(LottoValidator::validateWinningNumbersInput)
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        println("\nPlease enter the bonus number.")
        return readValidatedInput { input ->
            LottoValidator.validateBonusNumber(input, winningNumbers)
        }
    }

    private fun <T> readValidatedInput(validator: (String) -> T): T {
        while (true) {
            try {
                val input = Console.readLine()
                return validator(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
} 