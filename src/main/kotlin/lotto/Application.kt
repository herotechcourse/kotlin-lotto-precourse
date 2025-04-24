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

    fun validateWinningNumber(input: String) {
        val separatedInputs = input.split(",").map { it.trim() }
        require(!input.isBlank()) { "[ERROR] Input cannot be blank." }
        require(separatedInputs.size == 6) { "[ERROR] Expecting 6 winning numbers coma separated" }


        separatedInputs.forEach { numberString ->
            val number = numberString.toIntOrNull()
                ?: throw IllegalArgumentException("[ERROR] Number must be numeric")
            require(number in 1..45) {
                "[ERROR] Invalid winning number: $numberString. Numbers should be between 1 and 45"
            }
        }
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

    fun readWinningNumbers(): List<Int> {
        while (true) {
            try {
                val input = Console.readLine()
                validator.validateWinningNumber(input)
                val inputNumbers = input.split(",").map { it.trim().toInt() }
                return inputNumbers
            } catch (e: IllegalArgumentException) {
                println(LottoMessages.invalidWinningNumbers)
            }
        }
    }

}

fun main() {
    // TODO: Implement the program
    // First input read and checked
    println(LottoMessages.welcome)
    val initiateLotto = InputView("initiateLotto")
    val budget = initiateLotto.readBudget()
    val numberOfTickets = budget / 1000

    // Tickets created and checked
    val ticketCreator = TicketGenerator()
    val ticketsList = ticketCreator.generateMultiples(numberOfTickets)

    //Second input read and checked
    println(LottoMessages.winningNumbers)
    val winningNumbers = InputView("winningNumbers")
    val readWinningNumbers = winningNumbers.readWinningNumbers()

}
