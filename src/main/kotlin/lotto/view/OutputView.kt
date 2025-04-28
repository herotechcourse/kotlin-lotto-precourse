package lotto.view

import lotto.model.Prize
import lotto.Lotto

class OutputView {
  fun printPurchasedTickets(tickets: List<Lotto>) {
    println("\nYou have purchased ${tickets.size} tickets.")
    tickets.forEach { ticket ->
      println(ticket.getNumbers().joinToString(", ", "[", "]"))
    }
    println()
  }
}