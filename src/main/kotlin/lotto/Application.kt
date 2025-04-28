package lotto

fun main() {
    // Temporary manual testing code
    val amount = readPurchaseAmount()
    validateAmount(amount)

    val tickets = generateTickets(amount)
    printTickets(tickets)
}
