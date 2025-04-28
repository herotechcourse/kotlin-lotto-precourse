package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    fun generateLottoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }

    fun generateLottos(count: Int): List<Lotto> {
        return List(count) { Lotto(generateLottoNumbers()) }
    }

    fun calculateWinningStatistics(lottos: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<Rank, Int> {
        val results = mutableMapOf<Rank, Int>()
        
        lottos.forEach { lotto ->
            val matchCount = lotto.matchCount(winningNumbers)
            val matchBonus = matchCount == 5 && lotto.contains(bonusNumber)
            
            val rank = Rank.getByMatchCountAndBonus(matchCount, matchBonus)
            if (rank != null) {
                results[rank] = results.getOrDefault(rank, 0) + 1
            }
        }
        
        return results
    }
}