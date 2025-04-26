package lotto.view

import lotto.controller.response.PurchasedTicketsDto

class OutputView {
    fun printPurchasedLotto(purchasedLotto: PurchasedTicketsDto) {
        println()
        println("You have purchased ${purchasedLotto.ticketCount} tickets.")
        purchasedLotto.tickets.forEach { ticket -> println(ticket.numbers) }
    }
}