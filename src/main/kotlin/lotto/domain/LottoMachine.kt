package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

class LottoMachine(private val money: Int) {

    val tickets: List<Lotto> = generateTickets()
    private val ranks = mutableListOf(0, 0, 0, 0, 0, 0, 0)

    private fun generateTickets(): List<Lotto> {
        return List(money / 1000) {
            generateSingleTicket()
        }
    }

    private fun generateSingleTicket(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
        return Lotto(numbers)
    }

    fun setAllRank(guessNumbers: Set<Int>, bonusNumber: Int): List<Int> {
        for (ticket in tickets) {
            val actualNumbers = ticket.numberSet()
            val matchCount = countMatch(actualNumbers, guessNumbers)
            val bonusMatch = checkBonusMatch(ticket, bonusNumber)
            setRank(matchCount, bonusMatch)
        }
        return ranks
    }

    private fun setRank(matchCount: Int, bonusMatch: Boolean) {
        val rank = LottoRank.findBy(matchCount, bonusMatch)
        if (rank != LottoRank.NONE) {
            ranks[rank.ordinal] += 1
        }
    }

    private fun countMatch(actualNumbers: Set<Int>, guessNumbers: Set<Int>): Int {
        return actualNumbers.intersect(guessNumbers).size
    }

    private fun checkBonusMatch(ticket: Lotto, bonusNumber: Int): Boolean {
        return ticket.numberSet().contains(bonusNumber)
    }

    fun calculateReturnRate(): Double {
        return calculateTotalPrize() / money.toDouble() * 100
    }

    private fun calculateTotalPrize(): Int {
        return LottoRank.entries
            .filter { it != LottoRank.NONE }
            .sumOf { it.prizeMoney * ranks[it.ordinal] }
    }
}
