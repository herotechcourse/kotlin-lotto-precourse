package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

/**
 * Represents a collection of Lotto tickets.
 *
 * This class is responsible for generating a list of [lotto.Lotto] tickets based on a given purchase amount.
 * Each ticket is composed of 6 unique random numbers between 1 and 45 (inclusive), sorted in ascending order.
 *
 * The internal list of tickets is immutable and accessible via [getAll] for display or evaluation.
 *
 * Usage:
 * ```
 * val tickets = LottoTickets.generate(8000)
 * println("Tickets: ${tickets.getAll()}")
 * println("Number of tickets: ${tickets.size()}")
 * ```
 */
class LottoTickets private constructor(private val tickets: List<Lotto>) {
    fun getAll(): List<Lotto> = tickets

    fun size(): Int = tickets.size

    companion object {
        private const val TICKET_PRICE = 1000

        fun generate(amount: Int): LottoTickets {
            val numberOfTickets = amount / TICKET_PRICE

            val tickets = List(numberOfTickets) {
                val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                    .sorted()
                Lotto(numbers)
            }

            return LottoTickets(tickets)
        }

        fun of(vararg lottos: Lotto): LottoTickets {
            return LottoTickets(lottos.toList())
        }
    }
}