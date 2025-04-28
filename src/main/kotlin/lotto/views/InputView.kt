package lotto.views

import camp.nextstep.edu.missionutils.Console
import lotto.Config

class InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter the purchase amount.")
        val input = Console.readLine().trim()
        return parsePurchaseAmount(input)
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter last week's winning numbers.")
        val input = Console.readLine().trim()
        return parseWinningNumbers(input)
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        println("Please enter the bonus number.")
        val input = Console.readLine().trim()
        return parseBonusNumber(input, winningNumbers)
    }

    companion object {
        fun parsePurchaseAmount(input: String): Int {
            val amount = input.toIntOrNull()
                ?: throw IllegalArgumentException("[ERROR] Invalid purchase amount.")
            require(amount > 0 && amount % Config.TICKET_PRICE == 0) {
                "[ERROR] Purchase amount must be a positive multiple of ${Config.TICKET_PRICE}."
            }
            return amount
        }

        fun parseWinningNumbers(input: String): List<Int> {
            val numbers = input
                .split(",")
                .map { it.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Invalid winning numbers.") }
            require(numbers.size == Config.LOTTO_NUMBER_COUNT) {
                "[ERROR] Winning numbers must contain exactly ${Config.LOTTO_NUMBER_COUNT} numbers."
            }
            require(numbers.toSet().size == numbers.size) { "[ERROR] Winning numbers must be unique." }
            numbers.forEach {
                require(it in Config.MIN_LOTTO_NUMBER..Config.MAX_LOTTO_NUMBER) {
                    "[ERROR] Lotto numbers must be between ${Config.MIN_LOTTO_NUMBER} and ${Config.MAX_LOTTO_NUMBER}."
                }
            }
            return numbers
        }

        fun parseBonusNumber(input: String, winningNumbers: List<Int>): Int {
            val bonus = input.toIntOrNull()
                ?: throw IllegalArgumentException("[ERROR] Invalid bonus number.")
            require(bonus in Config.MIN_LOTTO_NUMBER..Config.MAX_LOTTO_NUMBER) {
                "[ERROR] Bonus number must be between ${Config.MIN_LOTTO_NUMBER} and ${Config.MAX_LOTTO_NUMBER}."
            }
            require(bonus !in winningNumbers) {
                "[ERROR] Bonus number must not be one of the winning numbers."
            }
            return bonus
        }
    }
}
