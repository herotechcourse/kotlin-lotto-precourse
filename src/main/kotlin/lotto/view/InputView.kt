package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Validator

object InputView {

    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        return Validator.validateAmount(Console.readLine())
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        return Validator.validateWinningNumbers(Console.readLine())
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")
        return Validator.validateBonusNumber(Console.readLine())
    }
}