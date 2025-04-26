package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun askPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        return InputValidator.validatePurchaseAmount(Console.readLine())
    }

    fun askWinningNumbers(): String {
        println("Please enter last week's winning numbers.")
        return InputValidator.validateBlank(Console.readLine())
    }
}