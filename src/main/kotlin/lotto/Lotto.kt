package lotto

import lotto.common.Constants
import lotto.domain.WinningLotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == Constants.LOTTO_SIZE) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.distinct().size == Constants.LOTTO_SIZE) { "[ERROR] Lotto numbers must be unique." }
        require(numbers.all { it in Constants.MIN_LOTTO_NUMBER..Constants.MAX_LOTTO_NUMBER }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    // TODO: Implement additional functions
    override fun toString(): String {
        return numbers.sorted().toString()
    }

    fun matchNumbers(winningLotto: WinningLotto) : Pair<Int, Boolean> {
        val matchedCount = numbers.count { it in winningLotto.getWinningNumbers() }
        val isBonusMatched = numbers.contains(winningLotto.getBonusNumber())
        return Pair(matchedCount, isBonusMatched)
    }
}