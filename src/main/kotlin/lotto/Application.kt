package lotto

import lotto.input.PurchaseAmountInputReader
import lotto.calculation.TicketCalculator

fun main() {

    //Read Purchase Amount input from the user
    val purchaseAmount = PurchaseAmountInputReader().read()

    val numberOfTickets = TicketCalculator().calculateNumberOfTickets(purchaseAmount)

}
