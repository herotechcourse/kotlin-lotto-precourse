package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.Constants.LOTTERY_NUMBER_COUNT
import lotto.util.Constants.MAX_LOTTERY_NUM
import lotto.util.Constants.MIN_LOTTERY_NUM
import java.math.BigDecimal
import java.math.RoundingMode

class LottoMachine {
    private val _lottos = mutableListOf<Lotto>()
    val lottos: List<Lotto>
        get() = _lottos.toList()

    fun generateLottos(count: Int) {
        repeat(count) {
            val numbers =
                Randoms.pickUniqueNumbersInRange(MIN_LOTTERY_NUM, MAX_LOTTERY_NUM, LOTTERY_NUMBER_COUNT).sorted()
            _lottos.add(Lotto(numbers))
        }
    }

    fun calculateResults(winningNumbers: List<Int>, bonusNumber: Int): Map<Prize, Int> {
        val results = Prize.entries.associateWith { 0 }.toMutableMap()

        _lottos.forEach { lotto ->
            val (matchCount, hasBonus) = lotto.match(winningNumbers, bonusNumber)
            val prize = Prize.from(matchCount, hasBonus)
            if (prize != null) {
                results[prize] = results.getOrDefault(prize, 0) + 1
            }
        }
        return results.toMap()
    }

    fun calculateROI(purchaseAmount: Int, results: Map<Prize, Int>): Double {
        val totalReward = results.entries.sumOf { (prize, count) -> prize.reward * count.toLong() }
        if (purchaseAmount == 0) return 0.0
        val roi = BigDecimal(totalReward).divide(BigDecimal(purchaseAmount), 3, RoundingMode.HALF_UP)
            .multiply(BigDecimal(100)).setScale(1, RoundingMode.HALF_UP).toDouble()
        return roi
    }
}