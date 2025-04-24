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