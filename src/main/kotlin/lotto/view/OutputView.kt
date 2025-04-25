package lotto.view

import lotto.service.Statistics

object OutputView {

        fun printTickets(tickets: List<List<Int>>) {
            println("=============== Ticket Purchase Summary ===============")
            println("You have purchased ${tickets.size} tickets.")
            tickets.forEach { println(it) }
            println("=======================================================")
            println()
        }

        fun printStatistics(statistics: Statistics) {
            println("*************** Lotto Winning Statistics ***************")
            statistics.toString()
                .lines()
                .forEach { println(it) }
            println("*********************************************************")
        }
    }
