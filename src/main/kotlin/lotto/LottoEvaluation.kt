package lotto

class LottoEvaluation(private val winningNumbers: List<Int>, private val bonusNumber: Int) {
    private val prizeTable = listOf(
        Prize(3, false, 5000, "3 Matches"),
        Prize(4, false, 50000, "4 Matches"),
        Prize(5, false, 1500000, "5 Matches"),
        Prize(5, true, 30000000, "5 Matches + Bonus Ball"),
        Prize(6, false, 2000000000, "6 Matches")
    )

    fun evaluate(lottos: List<Lotto>, purchaseAmount: Int): LottoResult {
        val matchCounts = MutableList(prizeTable.size) { 0 }

        for (lotto in lottos) {
            val matchCount = lotto.countMatch(winningNumbers)
            val hasBonus = lotto.hasBonus(bonusNumber)

            val prizeIndex = prizeTable.indexOfFirst { it.isWinning(matchCount, hasBonus) }
            if (prizeIndex != -1) {
                matchCounts[prizeIndex]++
            }
        }

        return LottoResult(matchCounts, prizeTable, purchaseAmount)
    }
}