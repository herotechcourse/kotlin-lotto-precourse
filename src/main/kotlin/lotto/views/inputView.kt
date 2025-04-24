package lotto.views
import camp.nextstep.edu.missionutils.Console

class InputView {
    fun inputTickets(): Int {
        println("Enter how much you wish to spend today:")
        val input = Console.readLine() ?: throw IllegalArgumentException("Input cannot be null.")
        return validateTickets(input)
    }

    fun validateTickets(input: String): Int {
        val inputValidated = input.toIntOrNull()
        if (inputValidated == null) {
            println("[ERROR] Must be a number! Please provide an integer value.")
            return inputTickets()
        } else if (inputValidated % 1000 != 0) {
            println("[ERROR] The amount must be divisible by 1000. Please try again.")
            return inputTickets()
        }
        return inputValidated
    }


    fun inputWinningNumber(): List<Int> {
        println("Enter 6 unique numbers between 1 and 45, separated by commas:")
        val input = Console.readLine() ?: throw IllegalArgumentException("Input cannot be null.")
        return validateWinningNumber(input)
    }

    fun validateWinningNumber(input: String): List<Int> {
        val numbers = input.split(",").map { it.trim() }
        if (numbers.size != 6) {
            println("[ERROR] You must provide exactly 6 numbers separated by commas. Please try again.")
            return inputWinningNumber()
        }
        val validatedNumbers = numbers.mapNotNull { it.toIntOrNull() }
        if (validatedNumbers.size != 6) {
            println("[ERROR] All inputs must be valid integers. Please try again.")
            return inputWinningNumber()
        }
        if (validatedNumbers.any { it !in 1..45 }) {
            println("[ERROR] All numbers must be between 1 and 45. Please try again.")
            return inputWinningNumber()
        }
        if (validatedNumbers.toSet().size != 6) {
            println("[ERROR] All numbers must be unique. Please try again.")
            return inputWinningNumber()
        }
        return validatedNumbers
    }

    fun inputSingleNumber(winningNumbers: List<Int>): Int {
        println("Enter a single number that is not in the winning numbers:")
        val input = Console.readLine() ?: throw IllegalArgumentException("Input cannot be null.")
        return validateSingleNumber(input, winningNumbers)
    }

    fun validateSingleNumber(input: String, winningNumbers: List<Int>): Int {
        val inputValidated = input.toIntOrNull()
        if (inputValidated == null) {
            println("[ERROR] Must be a valid number. Please try again.")
            return inputSingleNumber(winningNumbers)
        }
        if (inputValidated in winningNumbers) {
            println("[ERROR] The number must not be one of the winning numbers. Please try again.")
            return inputSingleNumber(winningNumbers)
        }
        if (inputValidated !in 1..45) {
            println("[ERROR] The number must be between 1 and 45. Please try again.")
            return inputSingleNumber(winningNumbers)
        }
        return inputValidated
    }
}
