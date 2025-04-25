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

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine()
        return inputValidator.validateBonusNumber(input, listOf())
    }
    /*[Single Responsibility Principle - InputView vs BonusNumber]
    *  InputView is responsible for handling user input and providing user-friendly validation messages
    *  whereas BonusNumber as a domain object must ensure its own validity upon creation to preserve domain integrity
    *  the domain object must defensively guarantee that it is never created with invalid values
    * */
}