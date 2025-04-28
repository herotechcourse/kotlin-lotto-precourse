package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == 6) { "[ERROR] Lotto numbers must be unique." }
    }

    // TODO: Implement additional functions
    fun matchCount(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers}
    }
    fun containsBonus(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }
    fun getSortedNumbers(): List<Int> {
        return numbers.sorted()
    }

}
