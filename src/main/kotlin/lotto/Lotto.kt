package lotto

import lotto.constants.LottoRank

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) {
            "[ERROR] Lotto numbers must not contain duplicates."
        }
    }

    fun match(winningNumbers: Set<Int>, bonusNumber: Int): LottoRank {
        val matchCount = numbers.count { winningNumbers.contains(it) }
        val hasBonus = numbers.contains(bonusNumber)

        return LottoRank.findRank(matchCount, hasBonus)
    }

    override fun toString(): String {
        return numbers.joinToString(prefix = "[", postfix = "]")
    }
}
