package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    Application().run()
}

class Application {

    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoService = LottoService()

    fun run() {
        val amount = inputView.readPurchaseAmount()
        val tickets = lottoService.generateTickets(amount)
        outputView.printTickets(tickets)
        val winningNumbers = inputView.readWinningNumbers()
        val bonus = inputView.readBonusNumber(winningNumbers)
    }
}

class InputView {

    fun readPurchaseAmount(): Int {
        while (true) {
            try {
                println("Please enter the purchase amount.")
                val input = Console.readLine() ?: throw IllegalArgumentException("[ERROR] Input cannot be null.")
                return validateAmount(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun validateAmount(input: String): Int {
        val amount = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Amount must be a number")
        if (amount % 100 != 0)  throw IllegalArgumentException("[ERROR] Amount must be divisible by 1,000.")
        return amount
    }

    fun readWinningNumbers(): List<Int> {
        while (true) {
            try {
                println("Please enter last week's winning numbers (comma-separated).")
                val input = Console.readLine() ?: throw IllegalArgumentException("[ERROR] Input cannot be null.")
                return parseNumbers(input)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                // Re-prompt for winning numbers
            }
        }
    }

    private fun parseNumbers(input: String): List<Int> {
        val numbers = input.split(",").map { it.trim().toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Winning numbers must be integers.") }
        if (numbers.size != 6 || numbers.any { it !in 1..45 } || numbers.distinct().size != 6) {
            throw IllegalArgumentException("[ERROR] Winning numbers must be 6 unique numbers between 1 and 45.")
        }
        return numbers
    }

    fun readBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            try {
                println("Please enter the bonus number.")
                val input = Console.readLine() ?: throw IllegalArgumentException("[ERROR] Input cannot be null.")
                return validateBonus(input, winningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                // Re-prompt for bonus number
            }
        }
    }

    private fun validateBonus(input: String, winningNumbers: List<Int>): Int {
        val bonus = input.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Bonus number must be an integer.")
        if (bonus !in 1..45 || bonus in winningNumbers) {
            throw IllegalArgumentException("[ERROR] Bonus number must be between 1 and 45 and not in winning numbers.")
        }
        return bonus
    }

}

class LottoService {

    fun generateTickets(amount: Int): List<Lotto> {
        val ticketCount = amount / 1000
        return List(ticketCount) { generateTicket() }
    }

    private fun generateTicket(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        return Lotto(numbers)
    }
}

class OutputView {
    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it.getNumbers()) }
    }
}