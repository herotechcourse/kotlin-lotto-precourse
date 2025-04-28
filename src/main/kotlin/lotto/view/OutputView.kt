package lotto.view

import lotto.Lotto


/**
 * Handles all output (printing) to the console for the lottery game.
 */
object OutputView {

    /**
     * Prints the number of purchased tickets.
     *
     * @param tickets the list of Lotto tickets
     */
    fun printTickets(tickets: List<Lotto>) {
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it) }
    }
}
