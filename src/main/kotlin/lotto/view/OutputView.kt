package lotto.view

import lotto.service.Statistics

object OutputView {

        fun printTickets(tickets: List<List<Int>>) {
            println("You have purchased ${tickets.size} tickets.")
            tickets.forEach { println(it) }
        }

        fun printStatistics(statistics: Statistics) {
            statistics.toString()
                .lines()
                .forEach { println(it) }
        }
    }
