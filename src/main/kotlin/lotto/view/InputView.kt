package lotto.view

import camp.nextstep.edu.missionutils.Console

/**
 * Handles all user input interactions for the Lotto application.
 *
 * This class is responsible for reading and validating:
 * - Purchase amount.
 * - A set of winning numbers input.
 * - Bonus number input.
 *
 * All input methods perform error checking and throw [IllegalArgumentException]
 *
 * Usage:
 * ```
 * val inputView = InputView()
 * val amount = inputView.inputAmount()
 * val winningNumbers = inputView.inputWinningNumbers()
 * val bonus = inputView.inputBonusNumber(winningNumbers)
 * ```
 */
class InputView {

    fun inputAmount(): Int {
        println("Hi! Welcome to the Lottery Ticket machine! The price for one ticket is 1,000 please enter a purchase amount :)")
        val input = Console.readLine()
        val amount = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")

        require(amount > 0 && amount % 1000 == 0) {
            "[ERROR] Amount must be a positive number divisible by 1,000."
        }

        return amount
    }

    fun inputWinningNumbers(): List<Int> {
        println("We have received your amount! Please enter your pick of 6 winning numbers between 1 and 45 separated by a comma e.g. 1,2,3,4,5,6.")
        val input = Console.readLine()
        val numbers = input.split(",")
            .map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] All winning numbers must be positive integers.") }

        require(numbers.size == 6) {
            "[ERROR] You must enter exactly 6 winning numbers."
        }

        require(numbers.toSet().size == 6) {
            "[ERROR] Winning numbers must not contain duplicates."
        }

        require(numbers.all { it in 1..45 }) {
            "[ERROR] Winning numbers must be between 1 and 45."
        }

        return numbers
    }

    fun inputBonusNumber(winningNumbers: List<Int>): Int {
        println("Lastly, please enter a bonus number.")
        val input = Console.readLine()
        val bonus = input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Bonus number must be a positive integer.")

        require(bonus in 1..45) {
            "[ERROR] Bonus number must be between 1 and 45."
        }

        require(!winningNumbers.contains(bonus)) {
            "[ERROR] Bonus number must not be a duplicate of a winning number."
        }

        return bonus
    }

}