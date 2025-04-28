package lotto

import lotto.input.end
import lotto.input.start

enum class Rank(val label: String, val prize: Long) {
    ZERO("0 Matches", 0),
    THREE("3 Matches", 5_000),
    FOUR("4 Matches", 50_000),
    FIVE("5 Matches", 1_500_000),
    FIVE_BONUS("5 Matches + Bonus Ball", 30_000_000),
    SIX("6 Matches", 2_000_000_000)
}

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must not be duplicated." }
        require( numbers.all { it in start..end }) {"[ERROR] Each number must be between $start and $end inclusive."}
    }

    // TODO: Implement additional functions

    fun getNumbers(): List<Int> {
        return numbers.toList()
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

    fun calculateRank(lotto: Lotto, bonusNumber: Int) : Rank {
        val winningNumbers = lotto.getNumbers().toSet()
        return match(winningNumbers, bonusNumber)
    }

}
