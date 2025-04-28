package lotto.domain

class WinningNumbers(private val numbers: List<Int>) {
    init {
        require(numbers.size == VALID_SIZE) { "[ERROR] Winning numbers must contain exactly $VALID_SIZE numbers." }
        require(numbers.size == numbers.distinct().size) { "[ERROR] Winning Numbers must not be duplicated." }
        require(isValidRange(numbers)) { "[ERROR] Winning numbers must be between $START_INCLUSIVE and $END_INCLUSIVE." }
    }

    private fun isValidRange(numbers: List<Int>): Boolean {
        return numbers.all { it in START_INCLUSIVE..END_INCLUSIVE }
    }

    companion object {
        private const val VALID_SIZE = 6
        private const val START_INCLUSIVE = 1
        private const val END_INCLUSIVE = 45
    }
}