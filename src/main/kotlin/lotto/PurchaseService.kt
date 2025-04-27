package lotto

import camp.nextstep.edu.missionutils.Console

/**
 * The PurchaseService class handles the process of purchasing Lotto tickets.
 * It validates user input, calculates the number of tickets based on the purchase amount,
 * and provides functionality to print the purchased tickets.
 */
class PurchaseService {

    fun getTicketCount(input: String? = null): Int {
        while (true) {
            val userInput = getUserInput(input)
            val amount = parseAmount(userInput) ?: continue
            try {
                validateAmount(amount)
                return calculateTicketCount(amount)
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }

    fun getUserInput(input: String?): String {
        return input ?: run {
            println("Please enter the purchase amount.")
            Console.readLine()
        }
    }

    fun parseAmount(userInput: String): Int? {
        return try {
            userInput.toInt()
        } catch (_: NumberFormatException) {
            println("[ERROR] Invalid input. Please enter a valid number.")
            null // Return null to indicate invalid input
        }
    }

    fun calculateTicketCount(amount: Int): Int {
        val ticketCount = amount / 1000
        println("You have purchased $ticketCount tickets.")
        return ticketCount
    }

    fun validateAmount(amount: Int) {
        if (amount < 1000) {
            throw IllegalArgumentException("Amount must be at least 1,000 KRW.")
        }
        if (amount % 1000 != 0) {
            throw IllegalArgumentException("Amount must be divisible by 1,000 KRW.")
        }
    }

    fun printTickets(tickets: List<Lotto>) {
        tickets.forEach { println(it) }
    }
}