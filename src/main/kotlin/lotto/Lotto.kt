package lotto

import camp.nextstep.edu.missionutils.Randoms
import util.Validator.checkLottoNumbersRules

class Lotto(private val numbers: List<Int>) {
    init {
        checkLottoNumbersRules(numbers)
    }

    override fun toString() = numbers.toString()

    fun toRank(winningNumbers: List<Int>, bonusNumber: Int): Rank? {
        val matchCount = matchCountFrom(winningNumbers)
        val isBonusMatched = numbers.contains(bonusNumber)

        return Rank.from(matchCount, isBonusMatched)
    }

    private fun matchCountFrom(winningNumbers: List<Int>) = numbers.intersect(winningNumbers).size

    companion object {
        fun create(): Lotto {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            return try { Lotto(numbers.sorted()) } catch (e: IllegalArgumentException) { create() }
        }
    }
}
