package lotto

class LottoGame(
    private val tickets: List<Lotto>,
    private val winningNumbers: Set<Int>,
    private val bonusNumber: Int
) {
    private val result = mutableMapOf(
        3 to 0, 4 to 0, 5 to 0, 52 to 0, 6 to 0
    )

    fun evaluate() {
        for (ticket in tickets) {
            val match = ticket.matchCount(winningNumbers)
            val hasBonus = ticket.contains(bonusNumber)

            when {
                match == 6 -> result[6] = result[6]!! + 1
                match == 5 && hasBonus -> result[52] = result[52]!! + 1
                match == 5 -> result[5] = result[5]!! + 1
                match == 4 -> result[4] = result[4]!! + 1
                match == 3 -> result[3] = result[3]!! + 1
            }
        }
    }

    fun getResults(): Map<Int, Int> {
        return result
    }

    fun calculateProfit(): Double {
        val prizeMoney = mapOf(
            3 to 5_000,
            4 to 50_000,
            5 to 1_500_000,
            52 to 30_000_000,
            6 to 2_000_000_000
        )

        val totalEarned = result.entries.sumOf { (rank, count) ->
            prizeMoney.getOrDefault(rank, 0) * count
        }
        val totalSpent = tickets.size * 1_000

        return (totalEarned.toDouble() / totalSpent) * 100
    }
}