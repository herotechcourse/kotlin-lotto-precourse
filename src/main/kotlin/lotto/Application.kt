package lotto

fun main() {
    val input=Input()
    val output = Output()

    val noOfTickets = input.getPurchaseAmount()
    val tickets = Random(noOfTickets).generateTickets()

    output.displayTickets(tickets)
    val winningNumbers = input.getWinningNumbers()
    val bonus= input.getBonus()
}
