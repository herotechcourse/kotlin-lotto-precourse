package lotto

import camp.nextstep.edu.missionutils.Console

object LottoMessages {
    val welcome = "Welcome to Lotto Machine! Please, insert the amount do you want to " +
            "invest on your Lotto Ticket. (It has to be divisible by 1000):"
    val tryAgainDivisible = " [ERROR] The amount has to be divisible by 1000! Please insert a correct amount value:"
    val winningNumbers = "Please, Enter 6 winning numbers (coma-separated):"
    val invalidWinningNumbers = "[ERROR] Invalid input. Please enter 6 winning numbers (coma-separated):"
    val invalidInput = "[ERROR] Invalid Input. Please try again:"
    val bonusNumber = "Digit a bonus number:"
}

class InputValidator {
    fun validateBudget(input: String) {
        require(!input.isBlank()) { "[ERROR] Input cannot be blank." }
        require(input > "1") { "[ERROR] Input cannot be smaller than 1" }
        require(input.toInt() % 1000 == 0) { "[ERROR] Input cannot be smaller than 1" }
    }
}

class InputView(val name: String) {
    val validator = InputValidator()

    fun readBudget(): Int {
        while (true) {
            try {
                val input = Console.readLine()
                validator.validateBudget(input)
                return input.toInt()
            } catch (e: IllegalArgumentException) {
                println(LottoMessages.tryAgainDivisible)
            }
        }
    }
}

fun main() {
    // TODO: Implement the program
    println(LottoMessages.welcome)
    val initiateLotto = InputView("initiateLotto")
    val budget = initiateLotto.readBudget()
    val numberOfTickets = budget / 1000

    val ticketCreator = TicketGenerator()
    val ticketsList = ticketCreator.generateMultiples(numberOfTickets)
}
