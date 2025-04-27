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

}
