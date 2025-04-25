package lotto

import lotto.domain.LottoMatchResult

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == REQUIRED_SIZE) { ERROR_INVALID_SIZE }
        require(numbers.toSet().size == REQUIRED_SIZE) { ERROR_DUPLICATE_NUMBERS }
        require(numbers.all { it in MIN_NUMBER..MAX_NUMBER }) { ERROR_OUT_OF_RANGE }
    }

    fun numbers(): List<Int> = numbers.toList()

    fun numberOfMatches(winningNumbers: List<Int>) : Int = numbers.count { it in winningNumbers }

    fun containsBonus(bonusNumber: Int): Boolean = bonusNumber in numbers

    fun toMatchResult(winningNumbers: List<Int>, bonusNumber: Int): LottoMatchResult {
        return LottoMatchResult(
            matchCount = numberOfMatches(winningNumbers),
            bonusMatched = containsBonus(bonusNumber)
        )
    }

    companion object {
        const val REQUIRED_SIZE = 6
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val ERROR_INVALID_SIZE = "[ERROR] Lotto must contain exactly 6 numbers."
        const val ERROR_DUPLICATE_NUMBERS = "[ERROR] Lotto numbers must not contain duplicates."
        const val ERROR_OUT_OF_RANGE = "[ERROR] Lotto numbers must be between 1 and 45."
    }
}
