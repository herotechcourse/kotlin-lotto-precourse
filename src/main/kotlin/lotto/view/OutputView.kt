package lotto.view

import lotto.Lotto

// Handle displaying output to the user
object OutputView {

    // Print the list of purchased Lotto tickets
    fun printTickets(tickets: List<Lotto>) {

        // Print the number of tickets purchased
        println("\nYou have purchased ${tickets.size} tickets.")

        // Iterate through each ticket and print its sorted numbers for validation
        tickets.forEach {

            // Print the sorted numbers of the current ticket
            println(it.getSortedNumbers())
        }

    }
}