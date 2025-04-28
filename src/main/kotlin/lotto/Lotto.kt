package lotto

import org.assertj.core.internal.Numbers

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "Lotto must contain exactly 6 numbers." }
        require(numbers.all { it in 1..45 }) { "Lotto numbers must be between 1 and 45." }
        require(numbers.distinct().size == 6) { "Lotto numbers must be unique." }
    }

    fun getNumbers(): List<Int> = numbers

    fun countMatches(winningNumbers: List<Int>): Int {
        return numbers.intersect(winningNumbers.toSet()).size
    }

    fun hasBonus(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }
}
