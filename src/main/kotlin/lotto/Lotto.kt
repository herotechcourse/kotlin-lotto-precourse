package lotto

enum class Rank {
    ZERO, THREE, FOUR, FIVE, FIVE_BONUS, SIX
}

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    // TODO: Implement additional functions

    fun getNumbers(): List<Int> {
        return numbers.toList()
    }

    fun match(winningNumbers: Set<Int>, bonusNumber: Int): Rank {
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
