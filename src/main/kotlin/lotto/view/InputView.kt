package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.exception.LottoInputException

/**
 * InputView is responsible for interacting with the user to get the necessary inputs.
 * It handles inputs for purchase amount, winning numbers, and bonus number, and throws appropriate exceptions for invalid inputs.
 */
object InputView {
    /**
     * Prompts the user to enter the purchase amount and validates the input.
     * The input is expected to be a positive integer, and any invalid input will throw an exception.
     */
    fun getPurchaseAmount(): Int {
        println(Constants.PURCHASE_QUESTION)

        val input = Console.readLine()
        return input.toIntOrNull() ?: throw LottoInputException.InvalidPurchaseInput(input)
    }

    /**
     * Prompts the user to enter the winning numbers for the lotto.
     * The input is expected to be a comma-separated list of 6 unique integers between 1 and 45.
     * If the input is invalid, an exception is thrown.
     */
    fun getWinningNumbers(): List<Int> {
        println(Constants.WINNING_NUMBERS_QUESTION)

        val input = Console.readLine()
        val tokens = input.split(",").map { it.trim() }

        if (tokens.size != 6 || tokens.any { it.toIntOrNull() == null })
            throw LottoInputException.InvalidWinningNumbersInput(input)

        return tokens.map { it.toInt() }
    }

    /**
     * Prompts the user to enter the bonus number for the lotto.
     * The input must be a valid integer between 1 and 45. Invalid inputs throw an exception.
     */
    fun getBonusNumber(): Int {
        println(Constants.BONUS_NUMBER_QUESTION)

        val input = Console.readLine()
        val bonus = input.toIntOrNull() ?: throw LottoInputException.InvalidBonusNumberInput(input)

        return bonus
    }

    /**
     * Contains the constant strings used for prompting the user for input.
     */
    object Constants {
        const val PURCHASE_QUESTION = "Please enter the purchase amount."
        const val WINNING_NUMBERS_QUESTION = "Please enter last week's winning numbers."
        const val BONUS_NUMBER_QUESTION = "Please enter the bonus number."
    }
}