package lotto.view

import lotto.exception.LottoInputException
import camp.nextstep.edu.missionutils.Console

object InputView {

    fun getPurchaseAmount(): Int {
        println(Constants.PURCHASE_QUESTION);
        val input = Console.readLine()
        return input.toIntOrNull() ?: throw LottoInputException.InvalidInput(input)
    }

    object Constants {
        const val PURCHASE_QUESTION = "Please enter the purchase amount."
        const val WINNING_NUMBERS_QUESTION = "Please enter last week's winning numbers."
        const val BONUS_NUMBER_QUESTION = "Please enter the bonus number."
    }
}