package lotto

import camp.nextstep.edu.missionutils.Console

class OutputView() {
    fun printPurchasedTickets(paidNumber: Int, tickets: List<List<Int>>) {
        println("You have purchased $paidNumber tickets.")
        tickets.forEach { ticket -> println("$ticket") }
    }
}
