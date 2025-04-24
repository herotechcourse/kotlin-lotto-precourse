package lotto

import lotto.domain.Bonus

class Lotto(private val numbers: List<Int>) {

    companion object {
        private const val LOTTO_COUNT = 6
        private const val START_NUMBER = 1
        private const val END_NUMBER = 45
    }

    init {
        validate(numbers)
    }

    fun countSameNumbers(other: Lotto): Int {
        return (START_NUMBER..END_NUMBER).count { this.contains(it) && other.contains(it) }
    }

    fun contains(number: Int): Boolean {
        return numbers.any { it == number }
    }

    fun hasBonus(bonus: Bonus): Boolean {
        return numbers.any { bonus.isSame(it) }
    }

    private fun validate(numbers: List<Int>) {
        checkIfNumberSizeIsValid(numbers)
        checkIfNumberRangeIsValid(numbers)
        checkIfNumbersAreDuplicate(numbers)
    }

    private fun checkIfNumberSizeIsValid(numbers: List<Int>) {
        require(numbers.size == LOTTO_COUNT) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    private fun checkIfNumberRangeIsValid(numbers: List<Int>) {
        require(numbers.all { it in START_NUMBER..END_NUMBER }) {
            "[ERROR] Lotto numbers must be between 1 and 45."
        }
    }

    private fun checkIfNumbersAreDuplicate(numbers: List<Int>) {
        require(numbers.toSet().size == numbers.size) {
            "[ERROR] There are duplicate numbers in the lotto ticket."
        }
    }

    override fun toString(): String {
        return numbers.sorted().toString()
    }
}
