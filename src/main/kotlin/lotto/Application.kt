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