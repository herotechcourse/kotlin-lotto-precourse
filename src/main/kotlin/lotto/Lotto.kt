package lotto

class Lotto(private val numbers: List<Int>) {
    companion object {
        private const val SIZE_ERROR = "[ERROR] Lotto must contain exactly 6 numbers."
        private const val RANGE_ERROR = "[ERROR] Numbers must be between 1 and 45."
        private const val DUPLICATE_ERROR = "[ERROR] Lotto numbers must not contain duplicates."
        private const val REQUIRED_SIZE = 6
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
    }

    init {
        validateSize(numbers)
        validateRange(numbers)
        validateNoDuplicates(numbers)
    }

    fun compare(other: Lotto): Int {
        return numbers.count { it in other.numbers }
    }

    fun containsNumber(number: Int): Boolean {
        return number in numbers
    }

    fun getNumbers(): List<Int> {
        return numbers.sorted()
    }

    private fun validateSize(numbers: List<Int>) {
        require(numbers.size == REQUIRED_SIZE) { SIZE_ERROR }
    }

    private fun validateRange(numbers: List<Int>) {
        require(numbers.all { it in MIN_NUMBER..MAX_NUMBER }) { RANGE_ERROR }
    }

    private fun validateNoDuplicates(numbers: List<Int>) {
        require(numbers.toSet().size == numbers.size) { DUPLICATE_ERROR }
    }
}