package lotto.view

import lotto.domain.LottoTickets

/**
 * Handles all user output for the Lotto application.
 *
 * This class is responsible for displaying:
 * - The number of tickets purchased.
 * - The list of generated Lotto tickets as per task requirements.
 *
 * OutputView does not handle any internal game logic or input operations—
 * it only formats and prints data provided by other components.
 *
 * Usage:
 * ```
 * val outputView = OutputView()
 * outputView.printTickets(lottoTickets)
 * ```
 */
class OutputView {
    fun printTickets(tickets: LottoTickets) {
        println("You have purchased ${tickets.size()} tickets.")

        tickets.getAll().forEach { ticket ->
            println(ticket.toString())
        }
    }
}