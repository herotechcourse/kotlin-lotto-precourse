package lotto
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // TODO: Implement the program
    val amount = readPuchaseAmount()
    val tickets = generateTickets(amount)
    println("\n You have purchased ${tickets.size} tickets(s):")
    for (ticket in tickets) {
        println(ticket)
    }
}
fun readPuchaseAmount(): Int {
    println("Enter the Purchase Amount:")
    val input = Console.readLine()
    val amount = input.toIntOrNull()
        ?: throw IllegalArgumentException("[Error] Input must be a valid integer.")

    if (amount <= 0 || amount % 100 != 0) {
        throw IllegalArgumentException("[Error] Amount must be a positive number divisible by 1000")
    }
    return amount
}
fun generateTickets(amount: Int): List<List<Int>> {
    val ticketCount = amount / 1000
    val tickets = mutableListOf<List<Int>>()

    repeat(ticketCount) {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            .sorted()
        tickets.add(numbers)
    }
    return tickets
}