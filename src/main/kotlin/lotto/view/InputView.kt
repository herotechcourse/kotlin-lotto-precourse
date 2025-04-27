package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        InputValidator.validatePurchaseAmount(input)
        return input.toInt()
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()
        InputValidator.validateWinningNumbers(input)
        return input.split(",")
            .map { it.trim().toInt() }
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine()
        InputValidator.validateBonusNumber(input)
        return input.toInt()
    }
}