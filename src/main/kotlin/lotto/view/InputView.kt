package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun askPurchaseAmount(): Int {
        println(ASK_PURCHASE_AMOUNT)
        return InputValidator.parseAndValidateNumber(Console.readLine())
    }

    fun askWinningNumbers(): String {
        println()
        println(ASK_WINNING_NUMBERS)
        return InputValidator.validateBlank(Console.readLine())
    }

    fun askBonusNumber(): Int {
        println()
        println(ASK_BONUS_NUMBER)
        return InputValidator.validateBlankAndParseNumber(Console.readLine())
    }

    companion object {
        private const val ASK_PURCHASE_AMOUNT = "Please enter the purchase amount."
        private const val ASK_WINNING_NUMBERS = "Please enter last week's winning numbers."
        private const val ASK_BONUS_NUMBER = "Please enter the bonus number."
    }
}