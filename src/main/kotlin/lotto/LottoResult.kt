package lotto

class LottoResult(private val ranks: List<Rank>) {

    fun countByRank(rank: Rank): Int {
        return ranks.count { it == rank }
    }

    fun calculateTotalPrize(): Int {
        return ranks.sumOf { it.prize }
    }

    fun calculateReturnRate(amount: Int): Double {
        val totalPrize = calculateTotalPrize()
        return (totalPrize.toDouble() / amount) * 100
    }
}
