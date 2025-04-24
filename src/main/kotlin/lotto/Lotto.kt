package lotto

import lotto.validation.RangeValidator

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        require(numbers.toSet().size == numbers.size) { "[ERROR] Lotto numbers must be unique." }
        numbers.forEach { RangeValidator.validateInRange(it) }
        require(numbers == numbers.sorted()) { "[ERROR] Lotto numbers must be sorted in ascending order." }
    }

    // Method to get the numbers
    fun getNumbers(): List<Int> {
        return numbers
    }
}
