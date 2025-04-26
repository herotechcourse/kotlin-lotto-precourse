package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readPurchaseAmount(): Int {
        println("\nPlease enter the purchase amount.")
        return InputValidator.validateAmount(Console.readLine())
    }

    fun readWinningNumbers(): List<Int> {
        println("\nPlease enter last week's winning numbers.")
        return InputValidator.validateWinningNumbers(Console.readLine())
    }

    fun readBonusNumber(): Int {
        println("\nPlease enter the bonus number.")
        return InputValidator.validateBonusNumber(Console.readLine())
    }
}