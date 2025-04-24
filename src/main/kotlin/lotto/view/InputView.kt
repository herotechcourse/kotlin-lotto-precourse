package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    private val inputValidator = InputValidator()

    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        return inputValidator.validatePurchaseAmount(input)
    }

    fun readWinningNumber(): List<Int> {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()
        return inputValidator.validateWinningNumbers(input)
    }

    fun readBounsNumber(): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine()
        return inputValidator.validateBonusNumber(input, listOf())
    }
}