package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoEngine {
    private const val TICKET_PRICE = 1000

    fun buyTickets(amount: Int): List<Lotto> {
        val ticketCount = amount / TICKET_PRICE
        return List(ticketCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            Lotto(numbers)
        }
    }

    fun evaluateTicketResults(tickets: List<Lotto>, winning: Set<Int>, bonus: Int): Map<Rank, Int> {
        return tickets.groupingBy {
            val match = it.matchCount(winning)
            val hasBonus = it.contains(bonus)
            Rank.of(match, hasBonus)
        }.eachCount().toSortedMap(compareByDescending { it.ordinal })
    }

    fun totalResultWinnings(results: Map<Rank, Int>): Int {
        return results.entries.sumOf { (rank, count) -> rank.prize * count }
    }
}