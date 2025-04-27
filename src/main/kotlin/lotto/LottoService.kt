package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoService {
    companion object {
        const val LOTTO_PRICE = 1000
    }

    fun purchaseLottos(amount: Int): List<Lotto> {
        validatePurchaseAmount(amount)
        val count = amount / LOTTO_PRICE
        return List(count) { createLotto() }
    }

    private fun validatePurchaseAmount(amount: Int) {
        if (amount <= 0) {
            throw IllegalArgumentException("[ERROR] Purchase amount must be greater than 0.")
        }
        if (amount % LOTTO_PRICE != 0) {
            throw IllegalArgumentException("[ERROR] Purchase amount must be divisible by 1,000.")
        }
    }

    private fun createLotto(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(numbers)
    }

    fun calculateResults(
        lottos: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumber: Int
    ): Map<LottoRank, Int> {
        val results = mutableMapOf<LottoRank, Int>()
        LottoRank.values().forEach { results[it] = 0 }

        lottos.forEach { lotto ->
            val matchCount = lotto.matchCount(winningNumbers)
            val hasBonus = lotto.contains(bonusNumber)
            val rank = LottoRank.calculateRank(matchCount, hasBonus)

            results[rank] = results.getOrDefault(rank, 0) + 1
        }

        return results
    }

    fun calculateTotalPrize(results: Map<LottoRank, Int>): Long {
        return results.entries.sumOf { (rank, count) -> rank.prize * count }
    }

    fun calculateProfitRate(prize: Long, purchaseAmount: Int): Double {
        return prize * 100.0 / purchaseAmount
    }
}