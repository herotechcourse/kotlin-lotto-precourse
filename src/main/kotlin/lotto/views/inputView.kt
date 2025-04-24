package lotto.views
import camp.nextstep.edu.missionutils.Console

class InputView {
}



fun inputTickets(): Int {
    println("Enter how much you wish to spend today:")
    val input = Console.readLine() ?: throw IllegalArgumentException("Input cannot be null.")
    return validateTickets(input)
}

fun validateTickets(input: String): Int {
    val inputValidated = input.toIntOrNull()
    if (inputValidated == null) {
        println("Error: Must be a number! Please provide an integer value.")
        return inputTickets()
    } else if (inputValidated % 1000 != 0) {
        println("Error: The amount must be divisible by 1000. Please try again.")
        return inputTickets()
    }
    return inputValidated
}


fun inputWinningNumber(): List<Int> {
    println("Enter 6 numbers separated by commas:")
    val input = readLine() ?: throw IllegalArgumentException("Input cannot be null.")
    return validateWinningNumber(input)
}

fun validateWinningNumber(input: String): List<Int> {
    val numbers = input.split(",").map { it.trim() }
    if (numbers.size != 6) {
        println("Error: You must provide exactly 6 numbers separated by commas. Please try again.")
        return inputWinningNumber()
    }
    val validatedNumbers = numbers.mapNotNull { it.toIntOrNull() }
    if (validatedNumbers.size != 6) {
        println("Error: All inputs must be valid integers. Please try again.")
        return inputWinningNumber()
    }
    return validatedNumbers
}