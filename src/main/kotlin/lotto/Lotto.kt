package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must not contain duplicates." }
        require(numbers.all { it in 1 until 45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    fun toRank(winningNumbers: List<Int>, bonusNumber: Int): Rank? {
        val matchCount = matchCountFrom(winningNumbers)
        val isBonusMatched = numbers.contains(bonusNumber)

        return Rank.from(matchCount, isBonusMatched)
    }

    private fun matchCountFrom(winningNumbers: List<Int>): Int {
        return numbers.intersect(winningNumbers).size
    }

    companion object {
        fun create(): Lotto {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            return try { Lotto(numbers) } catch (e: IllegalArgumentException) { create() }
        }
    }
}
