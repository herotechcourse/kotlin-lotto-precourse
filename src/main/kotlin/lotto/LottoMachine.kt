package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    private val ticketPrice = 1_000

    fun buyLottos(amount: Int): List<Lotto> {
        require(amount >= ticketPrice) { "[ERROR] Purchase amount must be at least 1,000 KRW." }
        require(amount % ticketPrice == 0) { "[ERROR] Purchase amount must be divisible by 1,000." }

        val ticketCount = amount / ticketPrice
        return List(ticketCount) { generateLotto() }
    }

    private fun generateLotto(): Lotto {
        return Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
    }
    fun checkResults(lottos: List<Lotto>, winningNumbers: Lotto, bonusNumber: Int): Map<LottoResult, Int> {
        val results = mutableMapOf<LottoResult, Int>()
        LottoResult.values().forEach { results[it] = 0 }

        lottos.forEach { lotto ->
            val matchCount = lotto.matchCount(winningNumbers)
            val hasBonus = matchCount == 5 && lotto.contains(bonusNumber)
            val result = LottoResult.from(matchCount, hasBonus)
            results[result] = results.getOrDefault(result, 0) + 1
        }

        return results
    }
}