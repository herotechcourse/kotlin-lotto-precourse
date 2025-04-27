package lotto.presentation

import lotto.Lotto

interface OutputView {
    fun printErrorMessage(errorMessage: String?)
    fun printNumberOfTickets(numberOfTickets: Int)
    fun printTickets(listOfTickets: List<Lotto>)
}

class OutputViewImpl : OutputView {
    override fun printErrorMessage(errorMessage: String?) {
        println("$ERROR_MESSAGE_PREFIX $errorMessage")
    }

    override fun printNumberOfTickets(numberOfTickets: Int) {
        println()
        println(NUMBER_OF_TICKETS_MESSAGE.format(numberOfTickets))
    }

    override fun printTickets(listOfTickets: List<Lotto>) {
        listOfTickets.forEach { ticket ->
            println(ticket)
        }
        println()
    }

    companion object {
        private const val ERROR_MESSAGE_PREFIX = "[ERROR]"
        private const val NUMBER_OF_TICKETS_MESSAGE = "You have purchased %d tickets."
    }
}