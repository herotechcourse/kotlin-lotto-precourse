package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {

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

    private fun validateAmount(amount: Int) {
        if (amount <= 0 || amount % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] Amount must be a positive number divisible by 1,000.")
        }
    }

    /**
     * Prompts the user to input last week's winning numbers and returns them as a list.
     *
     * @return a list of 6 unique winning numbers
     */
    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine()

        val numbers = try {
            input.split(",")
                .map { it.trim().toInt() }
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Please enter valid numbers separated by commas.")
        }

        validateWinningNumbers(numbers)
        return numbers
    }

    private fun validateWinningNumbers(numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException("[ERROR] Must input exactly 6 numbers.")
        }
        if (numbers.toSet().size != 6) {
            throw IllegalArgumentException("[ERROR] Numbers must be unique.")
        }
        if (numbers.any { it !in 1..45 }) {
            throw IllegalArgumentException("[ERROR] Numbers must be between 1 and 45.")
        }
    }

    /**
     * Prompts the user to input the bonus number.
     *
     * @param winningNumbers the list of winning numbers for duplicate check
     * @return the validated bonus number
     */
    fun readBonusNumber(winningNumbers: List<Int>): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine()

        val bonus = try {
            input.trim().toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("[ERROR] Please enter a valid number.")
        }

        validateBonusNumber(bonus, winningNumbers)
        return bonus
    }

    private fun validateBonusNumber(bonus: Int, winningNumbers: List<Int>) {
        if (bonus !in 1..45) {
            throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
        }
        if (winningNumbers.contains(bonus)) {
            throw IllegalArgumentException("[ERROR] Bonus number must not duplicate winning numbers.")
        }
    }
}