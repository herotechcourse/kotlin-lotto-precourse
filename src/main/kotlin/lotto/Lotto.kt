package lotto

import lotto.constants.LottoRank
import lotto.domain.validator.Validator

class Lotto(private val numbers: List<Int>) {
    init {
        Validator.validateCount(numbers)
        Validator.validateDuplication(numbers)
        numbers.forEach { Validator.validateRange(it) }
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
