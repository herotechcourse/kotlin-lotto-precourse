package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun askPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        return InputValidator.parseAndValidateNumber(Console.readLine())
    }

    fun askWinningNumbers(): String {
        println()
        println("Please enter last week's winning numbers.")
        return InputValidator.validateBlank(Console.readLine())
    }

    fun askBonusNumber(): Int {
        println()
        println("Please enter the bonus number.")
        return InputValidator.validateBlankAndParseNumber(Console.readLine())
    }
}