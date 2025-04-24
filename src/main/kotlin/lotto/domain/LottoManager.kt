package lotto.domain

import lotto.Lotto

class LottoManager(
    private val lottos: List<Lotto>,
    winningLotto: Lotto,
    bonus: Bonus
) {

    private val lottoResultMap: MutableMap<LottoResult, Int> = mutableMapOf()

    init {
        getLottoResultFrom(winningLotto, bonus)
    }

    fun calculateWinningAmount(): Int {
        return lottoResultMap.entries.sumOf { (result, count) ->
            result.winningAmount * count
        }
    }

    fun getLottoResultMap(): Map<LottoResult, Int> = lottoResultMap

    private fun getLottoResultFrom(winningLotto: Lotto, bonus: Bonus) {
        setLottoResultMap()
        lottos.forEach { lotto ->
            compareWith(winningLotto, bonus, lotto)
        }
    }

    private fun setLottoResultMap() {
        LottoResult.entries.forEach { result ->
            lottoResultMap[result] = 0
        }
    }

    private fun compareWith(winningLotto: Lotto, bonus: Bonus, lotto: Lotto) {
        val matchingCount = findMatchingCount(winningLotto, lotto)
        val doesBonusMatch = lotto.hasBonus(bonus)
        val lottoResult = LottoResult.getLottoResult(matchingCount, doesBonusMatch)
        lottoResult?.let {
            lottoResultMap[it] = lottoResultMap.getValue(it) + 1
        }
    }

    private fun findMatchingCount(winningLotto: Lotto, lotto: Lotto): Int {
        return winningLotto.countSameNumbers(lotto)
    }
}