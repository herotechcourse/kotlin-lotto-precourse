package lotto

import lotto.util.Constants.LOTTERY_NUMBER_COUNT

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == LOTTERY_NUMBER_COUNT) {
            "[ERROR] Lotto numbers cannot contain duplicate numbers."
        }
    }

    fun match(winningNumbers: List<Int>, bonusNumber: Int): Pair<Int, Boolean> {
        val matchCount = numbers.intersect(winningNumbers.toSet()).size
        val hasBonus = numbers.contains(bonusNumber)
        return Pair(matchCount, hasBonus)
    }

    override fun toString(): String {
        return numbers.sorted().joinToString(", ", "[", "]")
    }
}
