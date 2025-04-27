package lotto

class Lotto(private val numbers: List<Int>) {
    companion object {
        private const val ERROR_PREFIX = "[ERROR] "
        private const val SIZE_ERROR = "${ERROR_PREFIX}Lotto must contain exactly 6 numbers."
        private const val UNIQUENESS_ERROR = "${ERROR_PREFIX}Lotto numbers must be unique."
        private const val RANGE_ERROR = "${ERROR_PREFIX}Lotto numbers must be between 1 and 45."
    }

    init {
        require(numbers.size == 6) { SIZE_ERROR }
        require(numbers.toSet().size == 6) { UNIQUENESS_ERROR }
        require(numbers.all { it in 1..45 }) { RANGE_ERROR }
    }

    fun getNumbers(): List<Int> {
        return numbers.toList()
    }

    fun countMatchingNumbers(winningNumbers: List<Int>): Int {
        return (numbers.count { it in winningNumbers })
    }

    fun containsBonusNumber(bonus: Int): Boolean {
        return (bonus in numbers)
    }
}
