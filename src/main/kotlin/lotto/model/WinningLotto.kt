package lotto.model

import lotto.Lotto
import lotto.exception.ExceptionMessage

class WinningLotto(private val numbers: List<Int>, private val bonusNumber: Int) {
    init {
        require(numbers.size == 6) { ExceptionMessage.INVALID_WINNING_LOTTO_SIZE.message }
        require(numbers.all { it in 1..45 }) { ExceptionMessage.INVALID_LOTTO_RANGE.message }
        require(bonusNumber in 1..45) { ExceptionMessage.INVALID_BONUS_RANGE.message }
        require(numbers.distinct().size == 6) { ExceptionMessage.DUPLICATE_WINNING_NUMBERS.message }
        require(bonusNumber !in numbers) { ExceptionMessage.BONUS_IN_WINNING_NUMBERS.message }
    }

    fun getNumbers(): List<Int> = numbers

    fun getBonusNumber(): Int = bonusNumber

    fun match(lotto: Lotto): PrizeRank {
        val matchCount = lotto.getNumbers().count{it in numbers}
        val hasBonus = lotto.containsNumber(bonusNumber)
        return PrizeRank.getRank(matchCount, hasBonus)
    }
}