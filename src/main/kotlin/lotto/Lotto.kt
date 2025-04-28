package lotto

import camp.nextstep.edu.missionutils.Randoms

enum class PrizeRank(
    val display: String,
    val amount: Int,
) {
    FIFTH("3 Matches (5,000 KRW)", 5_000),
    FOURTH("4 Matches (50,000 KRW)", 50_000),
    THIRD("5 Matches (1,500,000 KRW)", 1_500_000),
    SECOND("5 Matches + Bonus Ball (30,000,000 KRW)", 30_000_000),
    FIRST("6 Matches (2,000,000,000 KRW)", 2_000_000_000);
}

class Lotto(private val numbers: List<Int>) {
    init {
        LotteryValidator.validateWinningNumbers(numbers)
    }

    companion object {
        const val TICKET_PRICE = 1000
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
    }

    fun purchaseTickets(amount: Int): MutableList<Set<Int>> {
        val tickets = mutableListOf<Set<Int>>()
        repeat(amount / TICKET_PRICE) {
            tickets.add(generateTicket())
        }
        return tickets
    }

    private fun generateTicket() =
        Randoms.pickUniqueNumbersInRange(1, 45, 6).toSortedSet()

    fun calculateResults(tickets: MutableList<Set<Int>>, bonusNumber: Int): Map<PrizeRank, Int> {
        return tickets.groupingBy { calculatePrize(it, bonusNumber) }
            .eachCount()
            .filterKeys { it != null }
            .mapKeys { it.key!! }
    }

    private fun calculatePrize(ticket: Set<Int>, bonusNumber: Int): PrizeRank? {
        val matchCount = ticket.intersect(numbers).size
        if (matchCount == 6) return PrizeRank.FIRST
        if (matchCount == 5 && ticket.contains(bonusNumber)) return PrizeRank.SECOND
        if (matchCount == 5) return PrizeRank.THIRD
        if (matchCount == 4) return PrizeRank.FOURTH
        if (matchCount == 3) return PrizeRank.FIFTH
        return null
    }
}
