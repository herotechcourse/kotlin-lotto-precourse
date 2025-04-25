package lotto.view

import lotto.service.Statistics

object OutputView {

        fun printTickets(tickets: List<List<Int>>) {
            println("\n============= Ticket Purchase Summary =============\n")
            println("You have purchased ${tickets.size} tickets.")
            tickets.forEach { println(it) }
            println("\n===================================================\n")

        }

        fun printStatistics(statistics: Statistics) {
            println("\n*************** Lotto Winning Statistics ***************")
            statistics.toString()
                .lines()
                .forEach { println(it) }
            println("**********************************************************")
        }
    }
