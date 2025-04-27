package lotto.domain

import lotto.Lotto

class Lottoes(private val tickets: List<Lotto>) {

    init {
        require(tickets.isNotEmpty()) { "[ERROR] At least one Lotto must be provided." }
    }

    fun getTickets(): List<Lotto> = tickets.toList()

    fun size(): Int = tickets.size
}