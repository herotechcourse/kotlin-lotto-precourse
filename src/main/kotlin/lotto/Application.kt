package lotto

import lotto.input.PurchaseAmountInputReader
import lotto.calculation.TicketCalculator
import lotto.calculation.TicketGenerator
import lotto.display.TicketDisplay

fun main() {

    //Read Purchase Amount input from the user
    val purchaseAmount = PurchaseAmountInputReader().read()

    // Calculate the number of tickets
    val numberOfTickets = TicketCalculator().calculateNumberOfTickets(purchaseAmount)

    // Generate random tickets as Lotto objects
    val tickets = TicketGenerator().generateTickets(numberOfTickets)

    // Display the generated Lotto tickets
    TicketDisplay().displayTickets(numberOfTickets, tickets)

}
