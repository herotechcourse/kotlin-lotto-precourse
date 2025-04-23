package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.validator.InputValidator

object InputView {

    fun getPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine().trim()
        return InputValidator.validateAmount(input)
    }

    fun getWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine().trim()
        return InputValidator.validateWinningNumbers(input)
    }

    fun getBonusNumber(): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine().trim()
        return InputValidator.validateBonusNumber(input)
    }
}
