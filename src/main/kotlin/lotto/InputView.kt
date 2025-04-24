package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        return Validator.validatePurchaseAmount(input)
    }

    fun readWinningNumbers(): Lotto {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()
        return Validator.validateWinningNumbers(input)
    }

    fun readBonusNumber(winningNumbers: Lotto): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine()
        return Validator.validateBonusNumber(input, winningNumbers)
    }
}