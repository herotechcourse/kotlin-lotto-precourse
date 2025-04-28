package lotto

class LottoResult(
    private val matchCounts: List<Int>, private val prizeTable: List<Prize>, private val purchaseAmount: Int
) {
    fun totalPrizeMoney(): Int {
        return matchCounts.indices.sumOf { idx -> matchCounts[idx] * prizeTable[idx].amount }
    }

    fun printStatistics() {
        OutputView.printWinningStatisticsTitle()
        for ((idx, count) in matchCounts.withIndex()) {
            val prize = prizeTable[idx]
            OutputView.printWinningResult(prize.printText, prize.amount, count)
        }
    }

    fun printReturnRate() {
        val returnRate = totalPrizeMoney().toDouble() / purchaseAmount * 100
        OutputView.printReturnRate(returnRate)
    }

    fun getMatchCounts(): List<Int> {
        return matchCounts
    }
}