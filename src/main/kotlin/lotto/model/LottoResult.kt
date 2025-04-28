package lotto.model

import lotto.Lotto

class LottoResult(private val winningNumber: WinningNumber, private val lotteries: List<Lotto>) {

    private val result: MutableMap<PrizeRank, Int> = mutableMapOf()

    fun calculateLottoMatch() {
        for (lotto in lotteries) {
            val matchCount = countMatchingNumbers(lotto)
            val matchBonus = checkBonusNumber(lotto)
            val rank = PrizeRank.of(matchCount, matchBonus)

            result[rank] = result.getOrDefault(rank, 0) + 1
        }

    }

    private fun countMatchingNumbers(lotto: Lotto): Int {
        return lotto.getNumbers().count { it in winningNumber.winningNumbers }
    }

    private fun checkBonusNumber(lotto: Lotto): Boolean {
        return winningNumber.bonusNumber in lotto.getNumbers()
    }

    fun getResult(): Map<PrizeRank, Int> {
        return result
    }


}