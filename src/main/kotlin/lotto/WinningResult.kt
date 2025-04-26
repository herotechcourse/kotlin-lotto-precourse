package lotto

data class WinningResult(private val ranks: List<LottoRank>, private val budget: Budget) {
    fun profit(): Double {
        return amount() / budget.amount.toDouble() * 100
    }

    private fun amount(): Int {
        return ranks.sumOf { it.prize }
    }
}
