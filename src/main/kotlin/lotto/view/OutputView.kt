package lotto.view

import lotto.support.Message
import lotto.Lotto

object OutputView {

    fun printPurchaseAmountPrompt() {
        println(Message.PURCHASE_AMOUNT_PROMPT)
    }

    fun printTickets(tickets: List<Lotto>){
        println()
        println(Message.PURCHASED_TICKETS_MESSAGE.format(tickets.size))
        for (ticket in tickets)
            println(ticket)
    }

    fun printWinningTicketPrompt(){
        println()
        println(Message.WINNING_TICKET_PROMPT)
    }

    fun printBonusNumberPrompt(){
        println()
        println(Message.BONUS_NUMBER_PROMPT)
    }

    fun printErrorMessage(message: String?) {
        println(message ?: Message.UNKNOWN_ERROR)
    }
}