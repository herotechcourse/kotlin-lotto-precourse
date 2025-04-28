package lotto.validation

import lotto.domain.END_NUMBER
import lotto.domain.START_NUMBER
import lotto.util.Split

object Input {

    fun isEmpty(input: String?): String {
        if (input.isNullOrEmpty()) {
            throw IllegalArgumentException("[ERROR] Input is empty")
        }
        return input
    }

    fun isInteger(input: String) {
        val number = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Input is not integer.")
    }

    fun isPositiveInteger(input: Int) {
        if (input <= 0) {
            throw IllegalArgumentException("[ERROR] Input must be positive integer.")
        }
    }

    fun isDivisible(input: Int, divisor: Int) {
        if (input % divisor != 0) {
            throw IllegalArgumentException("[ERROR] Input must be divisible by $divisor.")
        }
    }

    fun isInRange(input: Int, start: Int, end: Int) {
        if (input < start || input > end) {
            throw IllegalArgumentException("[ERROR] Input must be between $start and $end inclusive.")
        }
    }

    fun isEachInteger(input: List<String>) {
        input.forEach {
            if (it.toIntOrNull() == null) {
                throw IllegalArgumentException("[ERROR] Each input must be an integer.")
            }
        }
    }

    fun bonusNumberDuplication(input: Int, numbers: List<Int>) {
        if (input in numbers) {
            throw IllegalArgumentException("[ERROR] Bonus number must not be duplicated with the winning numbers")
        }
    }

    fun isPurchaseAmountValid(rawInput: String?, ticketCost: Int): Int {
        val input = Input.isEmpty(rawInput)
        Input.isInteger(input)
        val number = input.toInt()
        Input.isPositiveInteger(number)
        Input.isDivisible(number, ticketCost)
        return number
    }

    fun isWinningNumbersValid(rawInput: String?): List<Int> {
        val input = Input.isEmpty(rawInput)
        val rawNumbers = Split.byComma(input).map { it.trim() }
        Input.isEachInteger(rawNumbers)
        val numbers = rawNumbers.map { it.toInt() }
        return numbers
    }

    fun isBonusNumberValid(rawInput: String?, numbers: List<Int>): Int {
        val input = Input.isEmpty(rawInput)
        Input.isInteger(input)
        val number = input.toInt()
        Input.isInRange(number, START_NUMBER, END_NUMBER)
        Input.bonusNumberDuplication(number, numbers)
        return number
    }
}