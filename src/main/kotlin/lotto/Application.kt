package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun readPurchaseAmount(): Int {
    println("Please enter the purchase amount.")
    val userInput = Console.readLine()
    val purchaseAmount = userInput.toIntOrNull()
        ?: throw IllegalArgumentException("[ERROR] purchase amount must be an integer")
    return purchaseAmount
}

fun validatePurchaseAmount(amount: Int) {
    if (amount <= 0) {
        throw IllegalArgumentException("[ERROR] amount must be a positive number.")
    }
    if (amount % 1000 != 0) {
        throw IllegalArgumentException("[ERROR] Each ticket costs 1,000 KRW")
    }
}

fun createOneTicket(): Lotto {
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    return Lotto(numbers)
}

fun createMultipleTickets(ticketCount: Int): List<Lotto> {
    val lottoTickets = mutableListOf<Lotto>()
    repeat(ticketCount){
        lottoTickets.add(createOneTicket())
    }
    return lottoTickets
}

fun readWinningNumbers(): List<Int> {
    println("Please enter last week's winning numbers. (comma-separated)")
    val winningNumbers = Console.readLine()
        .split(",")
        .map { it.trim().toInt()}
    return winningNumbers
}

fun validateWinningNumbers(winningNumbers: List<Int>) {
    if (winningNumbers.size != 6) {
        throw IllegalArgumentException("[ERROR] Exactly 6 numbers must be entered.")
    }
    if (winningNumbers.toSet().size != winningNumbers.size){
        throw IllegalArgumentException("[ERROR] Duplicate numbers are not allowed.")
    }
    if (winningNumbers.any { it < 1 || it > 45 }) {
        throw IllegalArgumentException("[ERROR] Numbers must be between 1 and 45.")
    }
}

fun main() {
    var amount: Int
    while (true) {
        try {
            amount = readPurchaseAmount()
            validatePurchaseAmount(amount)
            break
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
    println()
    val ticketCount = amount / 1000
    println("You have purchased $ticketCount tickets.")
    val tickets = createMultipleTickets(ticketCount)
    for (ticket in tickets){
        println(ticket)
    }
    println()
    while (true){
        try {
            val winningNumbers = readWinningNumbers()
            validateWinningNumbers(winningNumbers)
            break
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}
