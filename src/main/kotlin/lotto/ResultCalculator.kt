package lotto

object ResultCalculator {

    fun calculateResults(
        tickets: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumber: Int
    ): Map<Int, Int> {
        val rankCount = mutableMapOf(3 to 0, 4 to 0, 5 to 0, 51 to 0, 6 to 0)
        tickets.forEach { ticket ->
            val matchCount = ticket.matchCount(winningNumbers)
            val rank = when {
                matchCount == 6 -> 6
                matchCount == 5 && ticket.containsBonus(bonusNumber) -> 51
                matchCount in 3..5 -> matchCount
                else -> 0
            }
            if (rank > 0) {
                rankCount[rank] = rankCount.getValue(rank) + 1
            }
        }
        return rankCount
    }
}
