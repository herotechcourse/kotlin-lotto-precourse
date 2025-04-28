package lotto

import lotto.util.Constants.LOTTERY_NUMBER_COUNT
import lotto.util.Constants.MAX_LOTTERY_NUM
import lotto.util.Constants.MIN_LOTTERY_NUM

class Lotto(inputNumbers: List<Int>) {
    val numbers: List<Int>

    init {
        require(inputNumbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(inputNumbers.toSet().size == LOTTERY_NUMBER_COUNT) {
            "[ERROR] Lotto numbers cannot contain duplicate numbers."
        }
        inputNumbers.forEach { number ->
            require(number in MIN_LOTTERY_NUM..MAX_LOTTERY_NUM) {
                "[ERROR] Lotto numbers must be between $MIN_LOTTERY_NUM and $MAX_LOTTERY_NUM"
            }
        }
        this.numbers = inputNumbers.sorted()
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
