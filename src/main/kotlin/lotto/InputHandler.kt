package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.LottoConstants.TICKET_PRICE

object InputHandler {

    private const val PURCHASE_AMOUNT_DIVISOR = 1000

    fun readAndValidatePurchaseAmount(): Int {
        do {
            println("Please enter the purchase amount.")
            val input = Console.readLine()
            try {
                return parsePurchaseAmount(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        } while (true)
    }

    private fun parsePurchaseAmount(input: String): Int {
        val amount = input.toIntOrNull()
        if (amount == null || amount % TICKET_PRICE != 0) {
            throw IllegalArgumentException("[ERROR] Amount must be a valid integer divisible by 1000.")
        }
        return amount
    }

    fun readAndValidateWinningNumbers(): List<Int> {
        do {
            println("Please enter last week's winning numbers.")
            val input = Console.readLine()
            try {
                return parseWinningNumbers(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        } while (true)
    }

    fun readAndValidateBonusNumber(): Int {
        do {
            println("Please enter the bonus number.")
            val input = Console.readLine()
            try {
                return parseBonusNumber(input)  // Try parsing the bonus number
            } catch (e: IllegalArgumentException) {
                println(e.message)  // Print the error message and re-prompt
            }
        } while (true)
    }

    private fun parseWinningNumbers(input: String): List<Int> {
        val numbers = input.split(",").map { it.trim().toIntOrNull() }
        if (numbers.size != 6 || numbers.contains(null) || numbers.distinct().size != 6 || numbers.any { it !in 1..45 }) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be 6 unique numbers between 1 and 45.")
        }
        return numbers.map { it!! }
    }

    private fun parseBonusNumber(input: String): Int {
        val bonus = input.toIntOrNull()
        if (bonus == null || bonus !in 1..45) {
            throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45.")
        }
        return bonus
    }

}
