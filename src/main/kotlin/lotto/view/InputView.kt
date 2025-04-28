package lotto.view

import lotto.exception.LottoInputException
import camp.nextstep.edu.missionutils.Console

object InputView {

    fun getPurchaseAmount(): Int {
        println(Constants.PURCHASE_QUESTION)

        val input = Console.readLine()
        return input.toIntOrNull() ?: throw LottoInputException.InvalidPurchaseInput(input)
    }

    fun getWinningNumbers(): List<Int> {
        println(Constants.WINNING_NUMBERS_QUESTION)

        val input = Console.readLine()
        val tokens = input.split(",").map {it.trim()}

        if (tokens.size != 6 || tokens.any { it.toIntOrNull() == null })
            throw LottoInputException.InvalidWinningNumbersInput(input)

        return tokens.map { it.toInt() }
    }

    fun getBonusNumber(): Int {
        println(Constants.BONUS_NUMBER_QUESTION)

        val input = Console.readLine()
        val bonus = input.toIntOrNull() ?: throw LottoInputException.InvalidBonusNumberInput(input)

        return bonus
    }

    object Constants {
        const val PURCHASE_QUESTION = "Please enter the purchase amount."
        const val WINNING_NUMBERS_QUESTION = "Please enter last week's winning numbers."
        const val BONUS_NUMBER_QUESTION = "Please enter the bonus number."
    }
}