package lotto

import camp.nextstep.edu.missionutils.Console

object InputView {
    fun purchaseAmount(): Int {
        while (true) {
            try {
                println("Please enter the purchase amount.")
                val amount = Console.readLine().trim().toInt()
                require(amount >= Constants.TICKET_PRICE && amount % Constants.TICKET_PRICE == 0) { Constants.ERROR_INVALID_AMOUNT }
                return amount
            } catch (e: NumberFormatException) {
                println(Constants.ERROR_INVALID_NUMBER)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun winningNumbers(): List<Int> {
        while (true) {
            try {
                println("Please enter last week's winning numbers.")
                val input = Console.readLine().trim()
                val numbers = input.split(",").map { it.trim().toInt() }
                require(numbers.size == Constants.LOTTO_NUMBER_COUNT) { Constants.ERROR_INVALID_WINNING_NUMBERS }
                require(numbers.toSet().size == Constants.LOTTO_NUMBER_COUNT) { Constants.ERROR_WINNING_NUMBERS_UNIQUE }
                require(numbers.all { it in Constants.MIN_NUMBER..Constants.MAX_NUMBER }) { Constants.ERROR_INVALID_BONUS_NUMBER }
                return numbers
            } catch (e: NumberFormatException) {
                println(Constants.ERROR_INVALID_NUMBERS)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun bonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            try {
                println("Please enter the bonus number.")
                val bonus = Console.readLine().trim().toInt()
                require(bonus in Constants.MIN_NUMBER..Constants.MAX_NUMBER) { Constants.ERROR_INVALID_BONUS_NUMBER }
                require(bonus !in winningNumbers) { Constants.ERROR_BONUS_NOT_IN_WINNING }
                return bonus
            } catch (e: NumberFormatException) {
                println(Constants.ERROR_INVALID_NUMBER)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}