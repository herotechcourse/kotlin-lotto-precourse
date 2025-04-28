package lotto

import lotto.domain.Rank
import lotto.domain.END_NUMBER
import lotto.domain.START_NUMBER

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must not be duplicated." }
        require(numbers.all { it in START_NUMBER..END_NUMBER }) { "[ERROR] Each number must be between $START_NUMBER and $END_NUMBER inclusive." }
    }

    // TODO: Implement additional functions

    fun getNumbers(): List<Int> {
        return numbers.toList()
    }

    fun calculateRank(lotto: Lotto, bonusNumber: Int): Rank {
        val winningNumbers = lotto.getNumbers().toSet()
        return match(winningNumbers, bonusNumber)
    }

    private fun match(winningNumbers: Set<Int>, bonusNumber: Int): Rank {
        val count = winningNumbers.intersect(numbers.toSet()).size
        if (count == 6) return Rank.SIX
        if (count == 5 && bonusNumber in numbers) return Rank.FIVE_BONUS
        if (count == 5) return Rank.FIVE
        if (count == 4) return Rank.FOUR
        if (count == 3) return Rank.THREE
        return Rank.ZERO
    }
}
