package lotto.core

import lotto.Lotto

class LottoGame(private val winningTicket: Lotto, private val bonusNumber: Int) {

    init {
        require(bonusNumber in 1..45) {"[ERROR] Bonus number must be between 1 and 45."}
    }

    internal fun evaluateTicket(ticket: Lotto): Prize {

        val matchCount = ticket.getNumbers().intersect(winningTicket.getNumbers()).size
        val hasBonus = ticket.getNumbers().contains(bonusNumber)

        return when (matchCount) {
            6 -> Prize.FIRST
            5 -> if (hasBonus) Prize.SECOND else Prize.THIRD
            4 -> Prize.FOURTH
            3 -> Prize.FIFTH
            else -> Prize.NONE
        }
    }


    fun evaluateTickets(tickets: List<Lotto>): Map<Prize, Int> {

        return tickets.map { evaluateTicket(it) }.groupBy { it }.mapValues { it.value.size }

    }

    fun calculateReturnRate(prizes: Map<Prize, Int>, purchaseAmount: Int): Double {

        val totalWin = prizes.entries.sumOf { (prize, count) -> prize.winningPrize * count}
        return (totalWin.toDouble() / purchaseAmount) * 100
    }
}