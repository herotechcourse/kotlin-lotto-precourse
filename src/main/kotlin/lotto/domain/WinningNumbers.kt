package lotto.domain

/**
 *  [ Background ]
 *  (1) Why does WinningNumbers have its own matching function?
 *      In OOP, each object must handle its own responsibility.
 *      WinningNumbers checks matches using its own numbers,
 *      just like Lotto checks using its own numbers.
 *      This keeps each object independent and responsible for its own data.
 */
class WinningNumbers(private val numbers: List<Int>) {

    init {
        validate(numbers)
    }

    private fun validate(numbers: List<Int>) {
        require(numbers.size == WINNING_NUMBER_COUNT) { ERROR_INVALID_SIZE_MESSAGE }
        require(numbers.toSet().size == WINNING_NUMBER_COUNT) { ERROR_DUPLICATE_NUMBERS_MESSAGE }
        require(numbers.all { it in WINNING_NUMBER_RANGE }) { ERROR_INVALID_NUMBER_RANGE_MESSAGE }
    }

    fun getNumbers(): List<Int> = numbers.toList()

    fun countMatches(lottoNumbers: List<Int>): Int {
        return numbers.count { it in lottoNumbers }
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

    companion object {
        private const val WINNING_NUMBER_COUNT = 6
        private val WINNING_NUMBER_RANGE = 1..45
        private const val ERROR_INVALID_SIZE_MESSAGE = "[ERROR] Winning numbers must contain exactly 6 numbers."
        private const val ERROR_DUPLICATE_NUMBERS_MESSAGE = "[ERROR] Winning numbers must be unique."
        private const val ERROR_INVALID_NUMBER_RANGE_MESSAGE = "[ERROR] Winning numbers must be between 1 and 45."
    }
}
