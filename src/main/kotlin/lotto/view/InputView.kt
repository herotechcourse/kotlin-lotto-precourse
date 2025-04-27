package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Validator

object InputView {

    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()
        return Validator.validateAmount(input)
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()
        return Validator.validateWinningNumbers(input)
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine()
        return Validator.validateBonusNumber(input)
    }
}