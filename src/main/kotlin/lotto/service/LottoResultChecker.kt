package lotto.service

import lotto.domain.Lotto
import lotto.domain.Prize

object LottoResultChecker {

    fun checkResults(lottos: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<Prize, Int> {
        val result = mutableMapOf<Prize, Int>()

        for (lotto in lottos) {
            val matchCount = lotto.countMatchingNumbers(winningNumbers)
            val bonusMatch = lotto.contains(bonusNumber)
            val prize = Prize.findPrize(matchCount, bonusMatch)

            result[prize] = result.getOrDefault(prize, 0) + 1
        }

        return result
    }
}
