package lotto

class WinningResult(
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {

    fun match(lottos: List<Lotto>): Map<Rank, Int> {
        val result = mutableMapOf<Rank, Int>()

        for (lotto in lottos) {
            val matchCount = countMatches(lotto)
            val bonusMatched = isBonusMatched(lotto)
            val rank = Rank.from(matchCount, bonusMatched)

            if (rank != Rank.NONE) {
                result[rank] = result.getOrDefault(rank, 0) + 1
            }
        }

        return result
    }

    private fun countMatches(lotto: Lotto): Int {
        return lotto.getNumbers().count { it in winningNumbers }
    }

    private fun isBonusMatched(lotto: Lotto): Boolean {
        return lotto.getNumbers().contains(bonusNumber)
    }
}
