package lotto

import lotto.domain.LottoMatchResult

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must not contain duplicates." }
        require(numbers.all { it in 1..45 }) { "[ERROR] Lotto numbers must be between 1 and 45." }
    }

    fun numbers(): List<Int> = numbers.toList()

    fun numberOfMatches(winningNumbers: List<Int>) : Int = numbers.count { it in winningNumbers}

    fun containsBonus(bonusNumber: Int): Boolean = bonusNumber in numbers

    fun toMatchResult(winningNumbers: List<Int>, bonusNumber: Int): LottoMatchResult {
        return LottoMatchResult(
            matchCount = numberOfMatches(winningNumbers),
            bonusMatched = containsBonus(bonusNumber)
        )
    }
}
