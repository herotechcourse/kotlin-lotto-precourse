package lotto

enum class PrizeRank(
    val display: String,
    val amount: Int,
    val order: Int
) {
    FIFTH("3 Matches (5,000 KRW)", 5_000, 1),
    FOURTH("4 Matches (50,000 KRW)", 50_000, 2),
    THIRD("5 Matches (1,500,000 KRW)", 1_500_000, 3),
    SECOND("5 Matches + Bonus Ball (30,000,000 KRW)", 30_000_000, 4),
    FIRST("6 Matches (2,000,000,000 KRW)", 2_000_000_000, 5);
}

class Lotto(private val numbers: Set<Int>) {

    companion object {
        const val TICKET_PRICE = 1000
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
    }

    private val tickets = mutableListOf<Set<Int>>()
    private lateinit var winningNumbers: Set<Int>
    private var bonusNumber: Int = 0

    fun purchaseTickets(amount: Int) {
        repeat(amount / TICKET_PRICE) {
            tickets.add(generateTicket())
        }
    }

    fun getTickets(): MutableList<Set<Int>> {
        return tickets
    }

    private fun generateTicket() =
        (1..45).shuffled().take(6).toSortedSet()

    fun setWinningNumbers(numbers: Set<Int>, bonus: Int) {
        winningNumbers = numbers.toSortedSet()
        bonusNumber = bonus
    }

    fun calculateResults(): Map<PrizeRank, Int> {
        return tickets.groupingBy { calculatePrize(it) }
            .eachCount()
            .filterKeys { it != null }
            .mapKeys { it.key!! }
    }

    private fun calculatePrize(ticket: Set<Int>): PrizeRank? {
        val matchCount = ticket.intersect(winningNumbers).size
        if (matchCount == 6) return PrizeRank.FIRST
        if (matchCount == 5 && ticket.contains(bonusNumber)) return PrizeRank.SECOND
        if (matchCount == 5) return PrizeRank.THIRD
        if (matchCount == 4) return PrizeRank.FOURTH
        if (matchCount == 3) return PrizeRank.FIFTH
        return null
    }
}
