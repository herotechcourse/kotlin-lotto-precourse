package lotto.common

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.model.Prize
import lotto.model.Winner

object LottoUtil {
    private const val MIN = 1
    private const val MAX = 45
    private const val COUNT = 6

    fun isValidLottoNumber(input: Int?): Boolean = input in MIN..MAX
    fun isValidLottoSize(input: List<Int?>): Boolean = input.size == COUNT
    fun generateNumbers(): List<Int> = Randoms.pickUniqueNumbersInRange(MIN, MAX, COUNT)
    fun getMatchCount(lotto: Lotto, winner: Winner) = winner.getNumbers().filter { lotto.contains(it) }.size
    fun isMatchBonus(lotto: Lotto, bonus: Int): Boolean = lotto.contains(bonus)
    fun calculateProfit(prizes: List<Prize>): Int = prizes.sumOf { it.getReward() }
    fun calculateProfitRate(profit: Int, totalSpent: Int): Double =
        Math.round((profit.toDouble() / totalSpent) * 100 * 10) / 10.0
}