package lotto

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    // Initialize PurchaseService to handle ticket purchase
    val purchaseService = PurchaseService()

    // Get the number of tickets the user wants to purchase
    val ticketCount = purchaseService.getTicketCount()

    // Simulate ticket generation logic here (this can be replaced with actual generation later)
    val sampleTickets = List(ticketCount) {
        // Generates 6 unique random numbers in the range 1 to 45
        Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
    }

    // Prints the generated tickets
    purchaseService.printTickets(sampleTickets)
}
