package lotto.ui

import lotto.domain.PurchasedLottos

class OutputView {
    fun printPurchasedLottos(purchasedLottos: PurchasedLottos) {
        val ticketAmount = purchasedLottos.count()
        println("\nYou have purchased $ticketAmount tickets.")
        purchasedLottos.getAllTickets().forEach{ticket->
            println(ticket)
        }
    }
}