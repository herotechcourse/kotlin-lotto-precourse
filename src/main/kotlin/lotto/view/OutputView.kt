package lotto.view

import lotto.Lotto

class OutputView {
  fun printTickets(tickets: List<Lotto>) {
    println()
    println("You have purchased ${tickets.size} tickets.")
    tickets.forEach { println(it.getSortedNumbers()) }
  }
}


