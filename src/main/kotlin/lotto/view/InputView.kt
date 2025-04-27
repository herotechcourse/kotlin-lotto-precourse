package lotto.view

import camp.nextstep.edu.missionutils.Console

/**
 * Handles all user input related to the lottery game.
 */
object InputView {

    /**
     * Prompts the user to enter the purchase amount and returns it.
     *
     * The amount must be a positive integer divisible by 1,000.
     * If the input is invalid, an [IllegalArgumentException] with a [ERROR] prefix is thrown.
     *
     * @return the validated purchase amount entered by the user.
     */
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine()

        return try {
            val amount = input.toInt()
            validateAmount(amount)
            amount
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Please enter a valid number.")
        }
    }

    /**
     * Validates that the purchase amount is positive and divisible by 1,000.
     *
     * @param amount the purchase amount to validate
     * @throws IllegalArgumentException if the amount is invalid
     */
    private fun validateAmount(amount: Int) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] Amount must be a positive number divisible by 1,000.")
        }
    }
}