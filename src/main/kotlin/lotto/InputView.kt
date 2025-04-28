package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): Int {
        while (true) {
            println(Constants.INPUT_PURCHASE_AMOUNT)
            val input = Console.readLine()

            try {
                val amount = input.toInt()
                Validator.validatePurchaseAmount(amount)
                return amount
            } catch (e: NumberFormatException) {
                println(Constants.ERROR_INVALID_NUMBER)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun readWinningLotto(): Lotto {
        while (true) {
            println(Constants.INPUT_WINNING_NUMBERS)
            val winningNumbersInput = Console.readLine()

            try {
                val winningNumbers = winningNumbersInput.split(",").map { it.trim().toInt() }
                Validator.validateWinningNumbers(winningNumbers)
                return Lotto(winningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            } catch (e: NumberFormatException) {
                println(Constants.ERROR_INVALID_NUMBER)
            }
        }
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            println(Constants.INPUT_BONUS_NUMBER)
            val input = Console.readLine()

            try {
                val bonusNumber = input.toInt()
                Validator.validateBonusNumber(bonusNumber, winningNumbers)
                return bonusNumber
            } catch (e: IllegalArgumentException) {
                println(e.message)
            } catch (e: NumberFormatException) {
                println(Constants.ERROR_INVALID_NUMBER)
            }
        }
    }
}