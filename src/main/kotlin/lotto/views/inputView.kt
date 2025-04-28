package lotto.views
import camp.nextstep.edu.missionutils.Console

class InputView {
    fun inputTickets(): Int {
        while (true) {
            try {
                println("Enter how much you wish to spend today:")
                val input = Console.readLine() ?: throw IllegalArgumentException("[ERROR] Input cannot be null.")
                return validateTickets(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun validateTickets(input: String): Int {
        val inputValidated = input.toIntOrNull()
        if (inputValidated == null) {
            throw IllegalArgumentException("[ERROR] Must be a number! Please provide an integer value.")
        } else if (inputValidated % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] The amount must be divisible by 1000. Please try again.")
        }
        return inputValidated
    }

    fun inputWinningNumber(): List<Int> {
        while (true) {
            try {
                println("Enter 6 unique numbers between 1 and 45, separated by commas:")
                val input = Console.readLine() ?: throw IllegalArgumentException("[ERROR] Input cannot be null.")
                return validateWinningNumber(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun validateWinningNumber(input: String): List<Int> {
        val numbers = input.split(",").map { it.trim() }
        if (numbers.size != 6) {
            throw IllegalArgumentException("[ERROR] You must provide exactly 6 numbers separated by commas.")
        }
        val validatedNumbers = numbers.mapNotNull { it.toIntOrNull() }
        if (validatedNumbers.size != 6) {
            throw IllegalArgumentException("[ERROR] All inputs must be valid integers.")
        }
        if (validatedNumbers.any { it !in 1..45 }) {
            throw IllegalArgumentException("[ERROR] All numbers must be between 1 and 45.")
        }
        if (validatedNumbers.toSet().size != 6) {
            throw IllegalArgumentException("[ERROR] All numbers must be unique.")
        }
        return validatedNumbers
    }

    fun inputSingleNumber(winningNumbers: List<Int>): Int {
        while (true) {
            try {
                println("Enter a single number that is not in the winning numbers:")
                val input = Console.readLine() ?: throw IllegalArgumentException("[ERROR] Input cannot be null.")
                return validateSingleNumber(input, winningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun validateSingleNumber(input: String, winningNumbers: List<Int>): Int {
        val inputValidated = input.toIntOrNull()
        if (inputValidated == null) {
            throw IllegalArgumentException("[ERROR] Must be a valid number.")
        }
        if (inputValidated in winningNumbers) {
            throw IllegalArgumentException("[ERROR] The number must not be one of the winning numbers.")
        }
        if (inputValidated !in 1..45) {
            throw IllegalArgumentException("[ERROR] The number must be between 1 and 45.")
        }
        return inputValidated
    }
}
